package com.holy.dao;


import com.holy.entity.User;

import java.util.List;

/**
 *  
 * <p>
 * Title: UserDao
 * </p>
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 *  @author holy   @date 2018-2-26 下午2:44:34    @version 1.0
 */
public interface UserDao {
	// 1、 根据用户ID查询用户信息
	User findUserById(int id) throws Exception;

	// 2、 根据用户名称模糊查询用户列表 
	List<User> findUsersByName1(String name) throws Exception;
	 
	// 2、 根据用户名称模糊查询用户列表
	List<User> findUsersByName2(String name) throws Exception;
		 
	// 3、 添加用户
	 int insertUser(User user) throws Exception;

}
