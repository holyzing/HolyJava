package com.holy.dao;

import com.holy.entity.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;



public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	@Override
	public User findUserById(int id) throws Exception {
		return this.getSqlSession().selectOne("test.findUserById");
	}
}
