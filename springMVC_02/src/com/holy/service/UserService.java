package com.holy.service;

import java.util.List;

import com.holy.entity.User;

public interface UserService {
	List<User> findAll();

	User getUser(int id);
}
