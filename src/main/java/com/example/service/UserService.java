package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll(){
		return userMapper.findAll();
	}
	
	public User findUser(User user) {
		System.out.println("到了UserService");
		return userMapper.findUser(user);
	}

	public boolean verifyLogin(User user) {
		System.out.println("Service的username="+user.getUsername());
		List<User> userList=userMapper.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		return userList.size()>0;
	}
}
