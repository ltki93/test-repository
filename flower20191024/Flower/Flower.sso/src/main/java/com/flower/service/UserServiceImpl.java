package com.flower.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.flower.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public Integer checkname(String name) {
		Integer num=userMapper.checkname(name);
		return num;
	}
	@Override
	public Integer checkntel(String tel) {
		Integer num=userMapper.checktel(tel);
		return num;
	}

}
