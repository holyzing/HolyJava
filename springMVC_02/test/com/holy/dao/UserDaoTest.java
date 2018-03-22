package com.holy.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.holy.entity.User;

public class UserDaoTest {
	// spring上下文
	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		// 读取spring的上下文，然后封装到ctx
		ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
