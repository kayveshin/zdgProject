package com.zhang.zdg2.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.config.DataConfig;
import com.zhang.zdg2.model.Account;
import com.zhang.zdg2.service.UserService;
import com.zhang.zdg2.util.RedisUtil;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Resource
	UserService userService;
	
	@Resource
	RedisUtil redisUtil;
	
	@RequestMapping(value="real",method = RequestMethod.POST)
	public String updateRealMessage(@RequestBody Account account) {
		return JSON.toJSONString(userService.updateUser(account));
	}
	
	@RequestMapping(value="detail",method = RequestMethod.POST)
	public String updateDetail(@RequestBody Account account) {
		return JSON.toJSONString(userService.updateUser(account));
	}
	
	@RequestMapping(value="available",method=RequestMethod.GET)
	public String extendAvailable(@CookieValue(DataConfig.SESSIONKEY)String key) {
		Account user=userService.getByid((String)redisUtil.Lget(key, 0));
		Date date=user.getValidityDate();
		date.setTime(date.getTime()+30*24*60*60*1000);
		user.setValidityDate(date);
		return JSON.toJSONString(userService.updateUser(user));
	}
	
	@RequestMapping(value="self",method=RequestMethod.GET)
	public String getSelf(@CookieValue(DataConfig.SESSIONKEY)String key) {
		
	    
	    	return JSON.toJSONString(userService.getByid((String)redisUtil.Lget(key, 0)));
	    
	}
	
	@RequestMapping(value="dgInfo",method=RequestMethod.GET)
	public String getDgById(@RequestParam("id")String id) {
		return JSON.toJSONString(userService.getByid(id));
	}
}
