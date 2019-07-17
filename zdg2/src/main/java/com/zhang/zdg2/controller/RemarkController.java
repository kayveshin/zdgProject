package com.zhang.zdg2.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.config.DataConfig;
import com.zhang.zdg2.model.Remark;
import com.zhang.zdg2.service.RemarkService;
import com.zhang.zdg2.util.RedisUtil;

@RestController
@RequestMapping("remark")
public class RemarkController {
	
	@Resource
	RemarkService remarkService;
	
	@Resource
	RedisUtil redisUtil;
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public String createRemark(@RequestBody Remark remark,@CookieValue(DataConfig.SESSIONKEY)String key) {
		remark.setDemanderId((String)redisUtil.Lget(key, 0));
		return JSON.toJSONString(remarkService.createRemark(remark));
	}
	
	@RequestMapping(value="dg",method = RequestMethod.GET)
	public String createRemark(@CookieValue(DataConfig.SESSIONKEY)String key) {
		return JSON.toJSONString(remarkService.getBydg((String)redisUtil.Lget(key, 0)));
	}
}
