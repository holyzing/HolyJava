package com.holy.mapper;


import com.holy.entity.User;
import com.holy.entity.UserQueryVO;

import java.util.List;

/**
 *  
 * <p>
 * Title: UserMapper Mappe代理的的方式开发持久层
 * </p>
 *  在普通dao开发持久层中存在大量的模板代码需要程序员重复写。
 *  在生成statement的时候传递的 id 存在硬编码情况，即在该方法中
 *  只能使用唯一方式的statement,
 *  
 *  普通dao开发方式是ibatis遗留下来的，mybatis对其进行了改进
 *  根据接口信息生写出接口的实现类：
 *  	1、mapper接口的全限定名要和mapper映射文件的namespace值一致。
		2、mapper接口的方法名称要和mapper映射文件的statement的id一致。
		3、mapper接口的方法参数类型要和mapper映射文件的statement的parameterType的值一致，而且它的参数有且只有一个。
		4、mapper接口的方法返回值类型要和mapper映射文件的statement的resultType的值一致。
    调用过程：      
 *      4：调用方法时，mybatis生成接口的代理类执行， 构造代理时的
 *         InvocationHandler由mmybatis生成
 *      4：接口的代理使用的是jdk的代理（jdk代理只能代理接口）
 *      
 */
public interface UserMapper {
	// 1、 根据用户ID查询用户信息
	 User findUserById(int id) throws Exception;

	// 3、 添加用户
	 void insertUser(User user) throws Exception;

	//综合查询
	  List<User> findUserList1(UserQueryVO vo);
	  List<User> findUserList2(UserQueryVO vo);
	//综合查询用户总数
	 int findUserCount(UserQueryVO vo);

	//resultMap入门
	 User findUserRstMap(int id);
}

