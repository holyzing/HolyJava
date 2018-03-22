package com.holy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * jdbc操作分为9步
 * @author hadoop
 * <p>
 * 	 说明：java提供了一套操作数据库的接口 具体实现由数据库厂商提供
 *        开发人员不用关注开发商的具体实现 只需要将具体数据库的驱动加载注册即可
 * </p>
 */
public class JDBCReview {
	public static void main(String[] args) {
		//0:声明jdbc相关变量
		Connection connection =null; //sql
		PreparedStatement preparedStatement = null;//sql
		ResultSet resultSet = null;  //sql
		
		try {
			//1:加载驱动并注册驱动到DriverManager
			Class.forName("com.mysql.jdbc.Driver"); 
			/*
			 * Class.forName()加载Driver且编译连接 执行Driver的静态代码块 与classLoader的区别
			 */
			//2:获取连接
			connection=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8",
						"root",
						"root");
			//3:准备sql（防注入）
			String sql = "select * from user where id = ?";
			//4:生成预处理的准备对象 (方法名和返回对象的名称)
			preparedStatement = connection.prepareStatement(sql);
			//5:设置参数 parameterIndex the first parameter is 1, the second is 2
			preparedStatement.setInt(1, 10);
			//6:执行操作，接收结果
			resultSet=preparedStatement.executeQuery();
			//7:处理结果 Before start of resultset
			while(resultSet.next()) {
				// resultSetIndex the first parameter is 1, the second is 2
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
				System.out.println(resultSet.getDate(3)+" "+resultSet.getString(4));
				System.out.println(resultSet.getString(5));
				//根据字段名称
				System.out.println(resultSet.getInt("id")+" "+resultSet.getString("username"));
				System.out.println(resultSet.getDate("birthday")+" "+resultSet.getString("sex"));
				System.out.println(resultSet.getString("address"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//TODO 8:从低到高关闭资源流 先关闭connection 会出现什么样的问题？
			try {
				//关闭顺序不对可能存在空指针异常
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
