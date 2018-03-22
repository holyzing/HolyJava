package com.holy.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * 在Java编程中，复制文件的方法有很多，而且经常要用到。我以前一直是缓冲输入输出流来实现的（绝大多数人都是如此），
 * 近来在研究JDK文档时发现，用文件通道（FileChannel）来实现文件复制竟然比用老方法快了近三分之一。 文件通道来实现文件复制，以及在效率上的对比
 * 而且FileChannel是多并发线程安全的。
 * 	1-文件复制时目的路径不能是一个目录
 *  2-java只能删除文件 以及空目录，当同名目录存在时不会覆盖目录，但当同名文件存在时则会覆盖文件
 *  3-StringBuffer   每次append都会动态拼接到 开辟 的buffer缓存中，而不会在字符串常量池中生成两个对象
 *  4-除根目录外，先判断文件先输出文件夹，先判断文件夹先输出文件,其实没改变 怎么改变呢？
 *  5-该拷贝程序 差点做成单起点拷贝 ，现在做的是目录下的内容到目录下的拷贝（第一层需要判重），
 *  	不是将目录拷贝到目录下（单目录判重）
 *  6-交互有问题
 * @author hadoop
 *
 */
public class FileUtil {
	
	private static void channelCopyFile(File src, File dest) {
		if (!src.isFile() & !dest.isFile()) {
			System.out.println("----------你所提供的文件不合法！----------");
			System.exit(0);
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel in = null;
		FileChannel out = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			in = fis.getChannel(); 
			out = fos.getChannel();
			in.transferTo(0, in.size(), out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				in.close();
				fos.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static StringBuffer buffer = new StringBuffer();
	private static int count = 0;
	private static Scanner sc = new Scanner(System.in);
	public static void copy(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if (!src.exists() | !dest.exists() | !dest.isDirectory()) {
			System.out.println("----------请检查你所提供的文件或文件夹路径是否存在于你的文件系统！----------");
			System.exit(0);
		}
		if (src.isFile()) {
			System.out.println("----------复制文件:"+src.getName());
			File newDest = new File(dest, src.getName());
			copyFile(src, newDest);
			System.exit(0);
		}
		System.out.println("----------请选择你要复制文件夹的方式：");
		System.out.println("--------------------1：将源文件夹及其内容复制到指定文件夹下");
		System.out.println("--------------------2：将源文件夹下的内容复制到指定文件夹下");
		System.out.println("--------------------3：退出系统");
		while (sc.hasNext()) {
			switch (sc.nextInt()) {
			case 1:
				File newDest = new File(dest,src.getName());
				sc.close();
				copyDirectory(newDest);
				OneToOne(src, newDest);
				System.exit(0);
			case 2:
				sc.close();
				ManyToOne(src, dest);
				System.exit(0);
			case 3:
				sc.close();
				System.exit(0);
			default:
				System.out.println("----------输入有误请重新输入：");
			}
		}
	}
	public static void ManyToOne(File src,File dest){
		count++;
		int temp = count;
		while (temp-- > 0) {
			buffer.append("---");
		}
		buffer.append(dest.getName()).append("\n");
		File[] listFiles = src.listFiles();
		for (File file : listFiles) {
			if (file.isDirectory()) {
				File dir=new File(dest,file.getName());
				int operate = copyDirectory(dir);
				switch(operate) {
					case 0:
						ManyToOne(file,dir);break;
					case 1:
						ManyToOne(file, dir);break;
					case 2:
						clearDirectory(dir);
						ManyToOne(file, dir);
					case 3:
						continue;
				}
				count--;
			}  else {
				temp = count + 1;
				while (temp-- > 0) {
					buffer.append("---");
				}
				buffer.append(file.getName()).append("\n");
				File newFile=new File(dest,file.getName());
				copyFile(file, newFile);
			}
		}
		
	}
	public static int copyFile(File src, File dest) {
		if (!dest.exists()) {
			channelCopyFile(src, dest);
			return 0;
		}
		
		System.out.println("----------该文件已经存在，请选择-- 1：重写 2：跳过 3：退出");
		while (sc.hasNext()) {
			switch (sc.nextInt()) {
			case 1:
				System.out.println("----------重写文件:"+src.getName());
				channelCopyFile(src, dest);
				sc.close();
				return 1;
			case 2:
				System.out.println("----------跳过文件:"+src.getName());
				sc.close();
				return 2;
			case 3:
				System.out.println("----------退出系统");
				System.exit(0);
			default:
				System.out.println("----------输入有误请重新输入：");
			}
		}
		sc.close();
		return 0;
	}
	public static int copyDirectory(File dest) {
		if (!dest.exists()) {
			dest.mkdir();
			return 0;
		}
		System.out.println("----------该文件夹已经存在，请选择-- 1：合并 2：覆盖 3：跳过 4：退出");
		while (sc.hasNext()) {
			switch (sc.nextInt()) {
			case 1:
				System.out.println("----------将源文件夹下的内容合并到目的文件下的同名文件夹:"+dest.getName());
				sc.close();
				return 1;
			case 2:
				System.out.println("----------覆盖文件夹"+dest.getName());
				clearDirectory(dest);
				sc.close();
				return 2;
			case 3:
				System.out.println("----------跳过复制文件夹"+dest.getName());
				sc.close();
				return 3;
			case 4:
				System.out.println("----------退出系统");
				System.exit(0);
			default:
				System.out.println("----------输入有误请重新输入：");
			}
		}
		sc.close();
		return 0;
	}
	public static void OneToOne(File src,File dest){
		File[] listFiles = src.listFiles();
		for (File file : listFiles) {
			if (file.isDirectory()) {
				File dir=new File(dest,file.getName());
				dir.mkdir();
				OneToOne(file, dir);
			}  else {
				buffer.append(file.getName()).append("\n");
				File newFile=new File(dest,file.getName());
				copyFile(file, newFile);
			}
		}
	}
	public static void clearDirectory(File directory) {
		count++;
		int temp = count;
		while (temp-- > 0) {
			buffer.append("---");
		}
		buffer.append(directory.getName()).append("\n");
		File[] listFiles = directory.listFiles();
		for (File file : listFiles) {
			if (file.isDirectory()) {
				clearDirectory(file);
				count--;
				file.delete();
			}  else {
				temp = count + 1;
				while (temp-- > 0) {
					buffer.append("---");
				}
				buffer.append(file.getName()).append("\n");
				file.delete();
			}
		}
	}
	public static void main(String[] args) {
		/**
		 * linux与Windows的文件路径表示不一样
		 * 
		 */
		System.out.println("------------------欢迎来到（你懂得！）文件复制系统------------------");
		String src = "/home/hadoop/0filetest/dst";   // 给定源文件路径
		String dest = "/home/hadoop/0filetest/dest2"; // 给定目的文件夹路径
		copy(src, dest);
	}
	
	public void bufferCopy(File src, File dest) {
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new BufferedInputStream(new FileInputStream(src));
			os = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] buffer = new byte[2048];
			int i = 0;
			while ((i = is.read(buffer)) != -1) {
				os.write(buffer, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
