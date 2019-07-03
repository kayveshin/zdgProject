package com.zhang.zdg1.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhang.zdg1.dao.UserMapper;

@RestController("/user")
public class UserController {
	
	@Resource
	UserMapper userMapper;
	
	@RequestMapping("/Login")
	public String userLogin() {
		return "hello world";
	}
	
	@RequestMapping("/Register")
	public String userRegister() {
		return "hello world";
	}
}
