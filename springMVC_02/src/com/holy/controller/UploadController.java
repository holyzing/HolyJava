package com.holy.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.holy.util.Commons;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
/**
 * 图片上传之后，立即回显使用 ajax
 * ajax虽然可以发送数据，但是本身不支持表单的提交(multipart/form-data )，特别是流的发送，
 * 
 * 偶尔会出现 类型转换异常 ？？？？？
 * @author hadoop
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request,String fileName,PrintWriter out){
		/* ajax.form提交表单时，表单没有指定上传文件的类型为 multipart/form-data
		 * 把文件流存在request中，但是request本身不支持流操作，它的子类实现了对其扩展
		 * 所以把Request强转成多部件请求对象，
		 */
		System.out.println(fileName);
		System.out.println("---------------------------------");
		MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
		//根据文件名称获取文件对象
		CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);
		//获取文件上传流
		byte[] fbytes = cm.getBytes();
		
		//文件名称在服务器有可能重复？
		String newFileName="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newFileName = sdf.format(new Date());
		
		Random r = new Random();
		
		for(int i =0 ;i<3;i++){
			newFileName=newFileName+r.nextInt(10);
		}
		
		//获取文件扩展名
		String originalFilename = cm.getOriginalFilename();
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		//创建jesy服务器，进行跨服务器上传
		Client client = Client.create();
		//把文件关联到远程服务器 
		WebResource resource = client.resource(Commons.PIC_HOST+"/upload/image"+newFileName+suffix);
		//上传
		resource.put(String.class, fbytes);
		
		
		//ajax回调函数需要会写，写什么东西？
		//图片需要回显：需要图片完整路径
		String fullPath = Commons.PIC_HOST+"/upload/"+newFileName+suffix;
		//数据库保存图片的相对路径.
		String relativePath="/upload/"+newFileName+suffix;
		//{"":"","":""}
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		
		//TODO ajax是如何调用的
		out.print(result);
		out.flush();
		out.close();		
	}
	
}
