package com.holy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.holy.entity.User;
import com.holy.mapper.UserMapper;
import com.holy.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}
	@Override
	public User getUser(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
}
