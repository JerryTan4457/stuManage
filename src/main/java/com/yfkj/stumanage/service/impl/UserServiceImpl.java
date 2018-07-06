package com.yfkj.stumanage.service.impl;

import com.yfkj.stumanage.mapper.UserMapper;
import com.yfkj.stumanage.pojo.User;
import com.yfkj.stumanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	 
	@Override
	public User userlogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.userlogin(user);
	}

}
