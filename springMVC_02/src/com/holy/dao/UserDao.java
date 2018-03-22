package com.holy.dao;


import com.holy.entity.User;

import java.util.List;


public interface UserDao {
	User findUserById(int id) throws Exception;
}
