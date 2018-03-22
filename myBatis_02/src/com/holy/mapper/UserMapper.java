package com.holy.mapper;

import java.util.List;

import com.holy.entity.User;
import com.holy.entity.UserExt;

public interface UserMapper {
	 List<UserExt> findUserConsumDetail();
	 User findUserById(int id);
	 int insertUser(User user);
}

