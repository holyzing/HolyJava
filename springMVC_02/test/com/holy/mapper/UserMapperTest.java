package com.holy.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.holy.entity.User;

public class UserMapperTest {
	// spring上下文
	private ApplicationContext ctx;
	@Before
	public void setUp() throws Exception {
		// 读取spring的上下文，然后封装到ctx
		ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		// 创建mapper对象
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		UserMapper userMapperFromMapperFactoryBean = (UserMapper) ctx.getBean("userMapperFromMapperFactoryBean");
		// 调用mapper对象的方法
		User user = userMapper.findUserById(1);
		System.out.println(user);
		System.out.println(userMapperFromMapperFactoryBean.findUserById(10));
	}
}
