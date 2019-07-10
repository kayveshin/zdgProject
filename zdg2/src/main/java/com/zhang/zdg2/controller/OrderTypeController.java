package com.zhang.zdg2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.model.Dgitype;
import com.zhang.zdg2.service.OrderTypeService;

@RestController
@RequestMapping("/orderType")
public class OrderTypeController {
	
	@Resource
	OrderTypeService orderTypeService;
	
	@RequestMapping("/list")
	public String getList() {
		return JSON.toJSONString(orderTypeService.getList());
	}
	
	@RequestMapping("/dgandtype")
	public String addDgAndType(@RequestBody List<Dgitype> list) {
		return JSON.toJSONString(orderTypeService.addlist(list));
	}
	
}
