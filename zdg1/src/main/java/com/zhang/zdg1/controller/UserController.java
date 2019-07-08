package com.zhang.zdg1.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg1.dao.UserMapper;
import com.zhang.zdg1.model.User;
import com.zhang.zdg1.model.UserExample;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	UserMapper userMapper;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String userLogin(@RequestBody User user) {
		UserExample example = new UserExample();
	    UserExample.Criteria criteria = example.createCriteria();
		
	    example.setDistinct(false);
	     
	    criteria.andNameEqualTo(user.getName());
	    criteria.andPasswordEqualTo(user.getPassword());
	    
	    
	     
	    List<User> userList=userMapper.selectByExample(example);
	   
	    if(userList.size()>1) return null;
	    else return JSON.toJSONString(userList.get(0));
	    
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String getUser(@RequestParam("id")Integer id) {
		UserExample example = new UserExample();
	    UserExample.Criteria criteria = example.createCriteria();
		
	    example.setDistinct(false);
	    
	    criteria.andIdEqualTo(id);
	    
	    
	     
	    List<User> userList=userMapper.selectByExample(example);
	    
	    if(userList.size()>1) return null;
	    else return JSON.toJSONString(userList.get(0));
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String userRegister(@RequestBody User user) {
		int result=userMapper.insertSelective(user);
		System.out.println("用户插入:"+result);
		
		return JSON.toJSONString(result);
	}
}
