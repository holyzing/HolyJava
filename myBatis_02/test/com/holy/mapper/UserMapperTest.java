package com.holy.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.holy.entity.User;
import com.holy.entity.UserExt;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testGetOrdersForUser() throws InterruptedException {
		Thread.sleep(3*1000);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<UserExt> orders = mapper.findUserConsumDetail();
		//TODO 为什么断点无效
		System.out.println(orders.size());
		sqlSession.close();
	}
	@Test
	public void testSqlSessionCache1() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user1 = mapper.findUserById(1);
		System.out.println(user1);
		
		User user2 = mapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();
	}
	/**
	 * 正式开发，是将mybatis和spring进行整合开发，事务控制在service中。
		一个service方法中包括 很多mapper方法调用。
			service{
				//开始执行时，开启事务，创建SqlSession对象
				//第一次调用mapper的方法findUserById(1)
				
				//第二次调用mapper的方法findUserById(1)，从一级缓存中取数据
				//方法结束，sqlSession关闭
			}
		如果是执行两次service调用查询相同 的用户信息，不走一级缓存，
		因为session方法结束，sqlSession就关闭，一级缓存就清空。
	 */
	@Test
	public void testSqlSessionCache2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user1 = mapper.findUserById(1);
		System.out.println(user1);
		
		User user = new User();
		user.setUsername("东哥1");
		user.setAddress("清河宝盛西里");
		//TODO 是自动提交的？
		mapper.insertUser(user);
		//sqlSession.commit();
		User user2 = mapper.findUserById(1);
		//增删改会清空缓存
		System.out.println(user2);

		sqlSession.close();
	}
	/*
	 * 二级缓存是mapper级别的。
		第一次调用mapper下的SQL去查询用户信息。查询到的信息会存到该mapper对应的二级缓存区域内。
		第二次调用相同namespace下的mapper映射文件中相同的SQL去查询用户信息。会去对应的二级缓存内取结果。
		如果调用相同namespace下的mapper映射文件中的增删改SQL，并执行了commit操作。会清空该namespace下的二级缓存。
		
		一级缓存指的是具体的sqlSession中的map  二级缓存指的不是具体的mapper，
		而是专为一个namespace开启的缓存区域，可以将它对应为一个mapper接口的缓存区域
		在hibernate中一级缓存指的是session 而二级缓存指的是sessionFactory
	 */
	@Test
	public void testMapperCache() {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();

		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
		User user1 = mapper1.findUserById(1);
		System.out.println(user1);
		/*
		 * 关闭SqlSession1
		 * 只有在关闭Session的时候才会将代理对象（statement的详细信息）写入到二级缓存 
		 */
		sqlSession1.close();

		// 第二次查询ID为1的用户
		User user2 = mapper2.findUserById(1);
		System.out.println(user2);
		// 关闭SqlSession2
		sqlSession2.close();
		/*
		 * Cache Hit Ratio [com.holy.mapper.UserMapper]: 0.5 缓存命中率 
		 * 第一次没有缓存命中率为  0 第二次已经，命中率为0.5
		 * 同一级缓存一样，在进行增删改并提交事物之后会清空二级缓存
		 * 二级缓存容易出现脏读的情况，可以定时刷新缓存。显然该二级缓存和hibernate的二级缓存
		 * 一样，建议缓存不经常变动的，但经常读取的数据
		 */
	}
	/**
			使用场景：对于访问响应速度要求高，但是实时性不高的查询，可以采用二级缓存技术。
			注意：在使用二级缓存的时候，要设置一下刷新间隔（cache标签中有一个flashInterval属性）
			来定时刷新二级缓存，这个刷新间隔根据具体需求来设置，比如设置30分钟、60分钟等，单位为毫秒。
			
			Mybatis二级缓存对细粒度的数据级别的缓存实现不好。
			场景：对商品信息进行缓存，由于商品信息查询访问量大，但是要求用户每次查询都是最新的商品信息，
			     此时如果使用二级缓存，就无法实现当一个商品发生变化只刷新该商品的缓存信息而不刷新其他商品缓存信息，
			     因为二级缓存是mapper级别的，当一个商品的信息发送更新，所有的商品信息缓存数据都会清空。
			解决: 需要在业务层根据需要对数据有针对性的缓存,比如可以对经常变化的 数据操作单独放到另一个namespace的mapper中。
	 */
}
