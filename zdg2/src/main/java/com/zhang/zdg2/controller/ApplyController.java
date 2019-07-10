package com.zhang.zdg2.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.model.Apply;
import com.zhang.zdg2.service.ApplyService;

@RestController
@RequestMapping("/apply")
public class ApplyController {
	
	@Resource
	ApplyService applyService;
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public String createApply(@RequestBody Apply apply,@CookieValue("user_id") String id) {
		return JSON.toJSONString(applyService.createApply(apply, id));
	}
	
	@RequestMapping(value="accept",method = RequestMethod.POST)
	public String acceptApply(@RequestBody Apply apply,@CookieValue("user_id") String id) {
		apply.setApplyState("accepted");
		return JSON.toJSONString(applyService.updateApply(apply));
	}
}
