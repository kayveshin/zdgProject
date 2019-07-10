package com.zhang.zdg2.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.model.Dgorder;
import com.zhang.zdg2.service.OrderService;

@RestController
@RequestMapping("order")
public class orderController {
	
	@Resource
	OrderService orderSerivce;
	
	@RequestMapping("/create")
	public String createOrder(@RequestBody Dgorder dgorder) {
		dgorder.setOrderStatus("unaccept");
		dgorder.setOpenTime(new Date());
		return JSON.toJSONString(orderSerivce.createOrder(dgorder));
	}
	
	@RequestMapping("/updateWithDg")
	public String updateOrder(@RequestBody Dgorder dgorder) {
		dgorder.setOrderStatus("accept");
		
		return JSON.toJSONString(orderSerivce.updateOrder(dgorder));
	}
	
	@RequestMapping("/state")
	public String getByState(@RequestParam String state) {
		
		
		
		return JSON.toJSONString(orderSerivce.getbyState(state));
	}
	
	@RequestMapping("/dg")
	public String getByDgid(@CookieValue("user_id")String id) {
		
		
		
		return JSON.toJSONString(orderSerivce.getbyDgid(id));
	}
	
	@RequestMapping("/demand")
	public String getByDemanderId(@CookieValue("user_id")String id) {
		return JSON.toJSONString(orderSerivce.getbyDemanderid(id));
	}
}
