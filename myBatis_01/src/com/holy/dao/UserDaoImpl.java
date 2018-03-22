package com.holy.dao;

import java.util.List;

import com.holy.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 *  
 * <p>
 * Title: UserDaoImpl   关云长肯定修改了代码生成模板
 * </p>
 *  
 * <p>
 * Description: TODO(普通dao的接口实现) 
 * <p>
 * <p>
 * Company: www.fxsm.com
 * </p>
 *  @author holy   @date 2018-2-26 下午2:44:34    @version 1.0
 */
public class UserDaoImpl implements UserDao {
    
	//由调用者注入工厂引用，工厂一般为单例的，与spring整合之后，由spring管理其单例模式
	//注入的方式有多种，AutoWired 构造注入 setXxx注入 ...
	/*
	 * sqlSession是不能作为成员变量的，因为它像struts的Action一样，内部也含有一块数据
	 * 区域，如果不同操作共享sqlSession则存在线程不安全的问题，所以它也应该和Action一样
	 * 设为多例的，且sqlSession在哪里打开就在哪里关闭
	 * 
	 * 在hibernate的dao层实现中，是通过spring中的HibernateTemplate中的切面编程实现对代码的简化的
	 */
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(); //占用连接池中与数据库的连接
		// 调用SqlSession的增删改查方法
		// 第一个参数：表示statement的唯一标示 
		/*
		 * 全局配置文件加载所有的映射文件 为了区分不同映射文件中所映射的具有相同id的statement
		 * 为每一个映射文件匹配一个namespace，则找到statement的id就必须加上namespace
		 * 
		 * 但是全局配置文件 typeAlias有啥作用呢？类的别名？
		 */
		User user = sqlSession.selectOne("test.findUserById", id);
		System.out.println(user);
		// 关闭资源 解除占用 实际上并没有关闭连接，连接依旧在连接池中，只不过是解除了占用
		//TODO 销毁了SessionFactory才会将连接池中的所有连接关闭 ？
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUsersByName1(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUsersByName1", name);
		System.out.println(list);
		sqlSession.close();
		return list;
	}
	
	@Override
	public List<User> findUsersByName2(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUsersByName2", name);
		List<User> list2 = sqlSession.selectOne("test.findUsersByName2", name);//在运行时会报错
		System.out.println(list);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*
		 *TODO  insert语句已经执行了，在执行的同时生成最大主键，但是写操作在事物没提交之前是存在于数据库缓冲区的
		 *		不会同步(改变)到数据库中的，select为读操作，直接读取id，然后填充到propertyKey中  
		 *		这是mysql对写操作的一种 ”保护方式“ ？？？？
		 */
		int insert = sqlSession.insert("test.insertUser", user);//
		//返回的是影响的记录数
		System.out.println(insert+"---------------"+user.getId()); 
		
		//sqlSession事物：AutoCommit=false
		// 写操作需要及时提交事物，因为（数据库）系统认为你后续可能还有对数据库的其它操作，
		// 所以并没有数据写入,只是存在缓冲区，但是需要保持数据库的一致性，所以手动提交事物，
		// 之所以手动是因为底层 conn.setAutoCommit(false) 读操作则不需要
		//切记：增删改操作时，要执行commit操作
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
		return insert;
	}

}
