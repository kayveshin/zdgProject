package com.zhang.zdg2.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhang.zdg2.model.Dgorder;

@RestController
@RequestMapping("order")
public class orderController {
	
	@RequestMapping("create")
	public String createOrder(@RequestBody Dgorder dgorder) {
		return "hello";
	}
	
	@RequestMapping("update")
	public String updateOrder(@RequestBody Dgorder dgorder) {
		return "hello";
	}
	
}
