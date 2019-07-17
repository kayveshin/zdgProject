package com.zhang.zdg2.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.config.DataConfig;
import com.zhang.zdg2.dao.AccountMapper;
import com.zhang.zdg2.model.Account;
import com.zhang.zdg2.model.AccountExample;
import com.zhang.zdg2.util.RedisUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	AccountMapper userMapper;
	
	@Resource 
	RedisUtil redisUtil;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String loginByNameAndPass(@RequestBody Account account,HttpServletResponse response,HttpServletRequest request) {
		//先从数据库中获取符合账号密码的信息
		AccountExample example=new AccountExample();
		AccountExample.Criteria criteria=example.createCriteria();
		
		example.setDistinct(false);
	     
	    criteria.andUsernameEqualTo(account.getUsername());
	    criteria.andPasswordEqualTo(account.getPassword());
	    
	    
	     
	    List<Account> userList=userMapper.selectByExample(example);
	   
	    if(userList.size()>1) return "false";
	    else {
	    	
	    	
	    	Account user=userList.get(0);
	    	
	    	String id=user.getId();
	    	//加密id作为sessionid
	    	String sessionKey=Base64.getEncoder().encodeToString(id.getBytes());
	    	
	    	
	    	//将用户放入
	    	List<Object> valueList=new ArrayList<Object>();
	    	valueList.add(id);
	    	valueList.add(user.getRole());
	    	valueList.add(request.getHeader("User-Agent")); //用该内容确认是否在不同的地方登陆
	    	redisUtil.Lset(sessionKey, valueList);
	    	Cookie cookie=new Cookie(DataConfig.SESSIONKEY, sessionKey);
	    	cookie.setPath("/");
	    	response.addCookie(cookie);
	    	return JSON.toJSONString(user);
	    }
		
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String register(@RequestBody Account account) {
		String id=UUID.randomUUID().toString();
		id=id.replace("-", "");
		account.setId(id);
		int result=userMapper.insertSelective(account);
		System.out.println("用户插入:"+result);
		return JSON.toJSONString(result);
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,@CookieValue(DataConfig.SESSIONKEY)String key) {
		redisUtil.Lremove(key);
		Cookie cookie=new Cookie(DataConfig.SESSIONKEY, null);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "ok";
	}
	
	@RequestMapping(value="/session",method=RequestMethod.GET)
	public String register(HttpServletRequest request,HttpServletResponse response) {
		String id=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(DataConfig.SESSIONKEY)) {
					id=(String)redisUtil.Lget(cookie.getValue(),0);
				}
			}
		}
		if(id!=null&&id!="") {
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
