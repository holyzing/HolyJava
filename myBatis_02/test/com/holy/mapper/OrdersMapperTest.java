package com.holy.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.holy.entity.Orders;
import com.holy.entity.OrdersExt;

public class OrdersMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testGetOrdersForUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> orders = mapper.getOrdersForUser();
		List<OrdersExt> user = mapper.findOrdersUserRstMap();
		List<OrdersExt> details = mapper.findOrdersAndOrderdetailRstMap();
		System.out.println(orders.size()+"----"+user.size()+"----"+details.size());
		sqlSession.close();
	}
	/**
	 * 懒加载（延迟加载），就是将一条级联查询的statement分解成多个statement，查询时只是执行了
	 * 主信息所对应的statement，通过日志输出的sql可以看出，也可以通过断点查看结果映射的映射情况
	 * 来看出 ，子信息确实没有被加载，这种情况称为 n+1，当子信息很多时，会影响数据库性能，（当然通
	 * 过一条sql查出也很慢）。但是在延迟加载机制下，只有在使用子信息的的结果映射的时候才会在数据库中查询
	 */
	@Test
	public void loadLazy() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> lazyLoadOrder = mapper.findOrdersUserLazyLoading();
		/*
		 当我们调用Orders中的getUser方法时，开始进行延迟加载。
		 去调用UserMapper.xml中findUserbyId这个方法获取用户信息。
		 */
		for(OrdersExt orders : lazyLoadOrder){
			//为什么在getUser()的时候就会执行 findUserById 呢？ 使用的是cglib的代理
			System.out.println(orders.getUser());
		}
		/*
		 * 延迟加载思考:不使用mybatis提供的association及collection中的延迟加载功能，如何实现延迟加载？？
				定义两个mapper方法：
					1、查询订单列表
					2、根据用户id查询用户信息
				实现思路：
					先去查询第一个mapper方法，获取订单信息列表
					在程序中（service），按需去调用第二个mapper方法去查询用户信息。
				总之：
				使用延迟加载方法，先去查询简单的sql（最好单表，也可以关联查询），再去按需要加载关联查询的其它信息。
		 */
		System.out.println(lazyLoadOrder.size());
		sqlSession.close();
	}

}
