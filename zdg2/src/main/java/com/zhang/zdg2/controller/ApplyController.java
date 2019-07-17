package com.zhang.zdg2.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.zdg2.config.DataConfig;
import com.zhang.zdg2.model.Apply;
import com.zhang.zdg2.model.Dgorder;
import com.zhang.zdg2.service.ApplyService;
import com.zhang.zdg2.service.OrderService;
import com.zhang.zdg2.util.RedisUtil;

@RestController
@RequestMapping("/apply")
public class ApplyController {
	
	@Resource
	ApplyService applyService;
	
	@Resource
	OrderService orderService;
	
	@Resource 
	RedisUtil redisUtil;
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public String createApply(@RequestBody Apply apply,@CookieValue(DataConfig.SESSIONKEY) String key) {
		return JSON.toJSONString(applyService.createApply(apply, (String)redisUtil.Lget(key, 0)));
	}
	
	@RequestMapping(value="getList",method=RequestMethod.GET)
	public String getListByOrderId(@RequestParam("id")String id) {
		return JSON.toJSONString(applyService.getApplyByOrder(id));
	}
	
	@RequestMapping(value="accept",method = RequestMethod.POST)
	public String acceptApply(@RequestBody Apply apply) {
		
		//将该订单的其他申请驳回
		List<Apply> list=applyService.getApplyByOrder(apply.getOrderId());
		for (Apply app : list) {
			app.setApplyState("reject");
		}
		
		//更改订单的状态
		Dgorder dgorder=new Dgorder();
		dgorder.setId(apply.getOrderId());
		dgorder.setDgId(apply.getDgId());
		dgorder.setOrderStatus("accepted");
		orderService.updateOrder(dgorder);
		
		//更新原申请的状态
		apply.setApplyState("accepted");
		return JSON.toJSONString(applyService.updateApply(apply));
	}
	
	
}
