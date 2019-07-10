package com.zhang.zdg2.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.dao.AccountMapper;
import com.zhang.zdg2.model.Account;
import com.zhang.zdg2.model.AccountExample;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	AccountMapper userMapper;
	
	@RequestMapping("/login")
	public String loginByNameAndPass(@RequestBody Account account,HttpServletResponse response) {
		AccountExample example=new AccountExample();
		AccountExample.Criteria criteria=example.createCriteria();
		
		example.setDistinct(false);
	     
	    criteria.andUsernameEqualTo(account.getUsername());
	    criteria.andPasswordEqualTo(account.getPassword());
	    
	    
	     
	    List<Account> userList=userMapper.selectByExample(example);
	   
	    if(userList.size()>1) return "false";
	    else {
	    	response.addCookie(new Cookie("user_id", userList.get(0).getId()));
	    	return JSON.toJSONString(userList.get(0));
	    }
		
	}
	
	@RequestMapping("/register")
	public String register(@RequestBody Account account) {
		int result=userMapper.insertSelective(account);
		System.out.println("用户插入:"+result);
		
		return JSON.toJSONString(result);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		response.addCookie(new Cookie("user_id", null));
		return "ok";
	}
	
	@RequestMapping("/session")
	public String register(HttpServletRequest request,HttpServletResponse response) {
		String id=null;
		for (Cookie cookie : request.getCookies()) {
			if(cookie.getName()=="user_id") {
				id=cookie.getValue();
			}
		}
		if(id!=null) {
			AccountExample example=new AccountExample();
			AccountExample.Criteria criteria=example.createCriteria();
			
			example.setDistinct(false);
		     
			criteria.andIdEqualTo(id);
		    
		    
		     
		    List<Account> userList=userMapper.selectByExample(example);
		   
		    if(userList.size()>1) return null;
		    else {
		    	return JSON.toJSONString(userList.get(0));
		    }
		}else {
			return null;
		}
	}
}
