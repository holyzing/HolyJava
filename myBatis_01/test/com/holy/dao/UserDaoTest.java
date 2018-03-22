package com.holy.dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;

import com.holy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


/**
 *  
 * <p>
 * Title: UserDaoTest
 * </p>
 * eclipse 集成了junit的单元测试框架 Junit test case
 * 如何将它配置到运行工具包中呢？？？？？
 */
public class UserDaoTest {

	private SqlSessionFactory sqlSessionFactory;
	private UserDao userDao;
	@Before
	public void setUp() throws Exception {
		// 读取配置文件
		// 全局配置文件的路径 类路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory 与spring整合时，由spring加载配置文件并注入
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		userDao= new UserDaoImpl(sqlSessionFactory);
	}
	@Test
	public void testFindUserById() throws Exception {
		User user = userDao.findUserById(10);
		System.out.println(user);
	}

	@Test
	public void testFindUsersByName() throws Exception {
		userDao.findUsersByName1("%明%"); 
		//前端参数不会有%%，如果写成 ”%“+name+”%“ 则存在前后必须模糊查询的硬编码
		userDao.findUsersByName2("明");
		//解决硬编码的常用方式就是引入配置文件，在user.xml中配置%${name}% 即可，
		//但是字符串的直接连接,存在sql注入的风险
	}

	@Test
	public void testInsertUser() throws Exception {
		User user = new User();
		user.setUsername("李瑶");
		user.setBirthday(new Date(1996, 07, 27));
		user.setSex("女");
		user.setAddress("魏晨依在西安!");
		userDao.insertUser(user);
	}
	
	@Test
	public void testJunit() {
		fail("junit内置方法");
	}

}
