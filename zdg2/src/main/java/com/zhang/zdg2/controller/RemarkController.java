package com.zhang.zdg2.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.model.Remark;
import com.zhang.zdg2.service.RemarkService;

@RestController
@RequestMapping("remark")
public class RemarkController {
	
	@Resource
	RemarkService remarkService;
	
	@RequestMapping("create")
	public String createRemark(@RequestBody Remark remark,@CookieValue("user_id")String id) {
		remark.setDemanderId(id);
		return JSON.toJSONString(remarkService.createRemark(remark));
	}
	
	@RequestMapping("dg")
	public String createRemark(@CookieValue("user_id")String id) {
		return JSON.toJSONString(remarkService.getBydg(id));
	}
}
