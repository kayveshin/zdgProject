package com.zhang.zdg2.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhang.zdg2.model.Account;

@RestController
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("updateself")
	public String updateSelf(@RequestBody Account account) {
		return "hello";
	}
	
}
