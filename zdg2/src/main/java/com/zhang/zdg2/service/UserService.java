package com.zhang.zdg2.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.zdg2.dao.AccountMapper;
import com.zhang.zdg2.model.Account;
import com.zhang.zdg2.model.AccountExample;

@Service
public class UserService {
	@Resource
	AccountMapper accountMapper;
	
	public int updateUser(Account record) {
		AccountExample example=new AccountExample();
		
		AccountExample.Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(record.getId());
		
		record.setId(null);
		
		return accountMapper.updateByExampleSelective(record, example);
	}
	
	
	
	public Account getByid(String id) {
		AccountExample example=new AccountExample();
		
		AccountExample.Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(id);
		List<Account> list=accountMapper.selectByExample(example);
		if(list.size()>1) return null;
		else return list.get(0);
	}
}
