package com.bw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.mapper.UserMapper;
import com.bw.pojo.User;

import com.bw.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User login(User user) {
		User u = userMapper.login(user);
		return u;
	}

}
