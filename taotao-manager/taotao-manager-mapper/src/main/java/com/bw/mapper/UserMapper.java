package com.bw.mapper;

import org.apache.ibatis.annotations.Select;

import com.bw.pojo.User;

public interface UserMapper {

	
	
	@Select("select * from user where uname=#{uname} and upwd=#{upwd}")
	User login(User user);

}
