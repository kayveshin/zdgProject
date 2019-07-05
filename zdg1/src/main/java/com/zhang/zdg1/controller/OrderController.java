package com.zhang.zdg1.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg1.dao.WireOrderMapper;
import com.zhang.zdg1.model.WireOrder;
import com.zhang.zdg1.model.WireOrderExample;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Resource
	WireOrderMapper orderMapper;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@RequestBody WireOrder record) {
		int result=orderMapper.insertSelective(record);
		System.out.println("订单插入:"+result);
		
		return JSON.toJSONString(result);
	}
	
	@RequestMapping(value="/status",method=RequestMethod.GET)
	public String getByStatus(@RequestParam("status")String status){
		WireOrderExample example=new WireOrderExample();
		WireOrderExample.Criteria criteria=example.createCriteria();
		
		example.setDistinct(false);
		criteria.andOrderStatusEqualTo(status);
		
		
		return JSON.toJSONString(orderMapper.selectByExample(example));
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(@RequestBody WireOrder order){
		
		WireOrderExample example=new WireOrderExample();
	
		WireOrderExample.Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(order.getId());
		
		order.setId(null);
		
		return JSON.toJSONString(orderMapper.updateByExampleSelective(order, example));
	}
}
