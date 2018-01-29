package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.User;

public interface UserMapper {

	@Select("SELECT * FROM user")
	List<User> findAll();
	
	@Select("SELECT * FROM user WHERE username=#{username}")
	User findUser(User user);

	@Select("SELECT * FROM user WHERE username=#{username} and password=#{password}")
	List<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
