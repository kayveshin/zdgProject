package com.zhang.zdg2.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.model.Dgorder;
import com.zhang.zdg2.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Resource
	OrderService orderSerivce;
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String createOrder(@RequestBody Dgorder dgorder) {
		dgorder.setOrderStatus("unaccept");
		dgorder.setOpenTime(new Date());
		return JSON.toJSONString(orderSerivce.createOrder(dgorder));
	}
	
	
	
	@RequestMapping(value="/unaccept",method = RequestMethod.GET)
	public String getByState() {
		
		
		
		return JSON.toJSONString(orderSerivce.getbyState("unaccept"));
	}
	
	@RequestMapping(value="/dg",method=RequestMethod.GET)
	public String getByDgid(@CookieValue("user_id")String id) {
		
		
		
		return JSON.toJSONString(orderSerivce.getbyDgid(id));
	}
	
	@RequestMapping(value="/demand",method=RequestMethod.GET)
	public String getByDemanderId(@CookieValue("user_id")String id) {
		return JSON.toJSONString(orderSerivce.getbyDemanderid(id));
	}
	
	@RequestMapping(value="/cancel",method=RequestMethod.POST)
	public String cancelOrder(@RequestBody Dgorder dgorder) {
		dgorder.setOrderStatus("cancel");
		return JSON.toJSONString(orderSerivce.updateOrder(dgorder));
	}
	
	@RequestMapping(value="/over",method=RequestMethod.POST)
	public String overOrder(@RequestBody Dgorder dgorder) {
		dgorder.setOrderStatus("over");
		return JSON.toJSONString(orderSerivce.updateOrder(dgorder));
	}
	
	
	
}
