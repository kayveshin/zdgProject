package com.zhang.zdg2.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.zdg2.dao.DgorderMapper;
import com.zhang.zdg2.model.Dgorder;
import com.zhang.zdg2.model.DgorderExample;

@Service
public class OrderService {
	
	@Resource
	DgorderMapper orderMapper;
	
	public int createOrder(Dgorder dgorder) {
		dgorder.setId(UUID.randomUUID().toString());
		int result=orderMapper.insertSelective(dgorder);
		System.out.println("订单插入:"+result);
		
		return result;
	}
	
	public int updateOrder(Dgorder dgorder) {
		DgorderExample example=new DgorderExample();
		
		DgorderExample.Criteria criteria=example.createCriteria();
		
		criteria.andIdEqualTo(dgorder.getId());
		
		dgorder.setId(null);
		
		return orderMapper.updateByExampleSelective(dgorder, example);
	}
	
	public List<Dgorder> getbyState(String state){
		DgorderExample example=new DgorderExample();
		DgorderExample.Criteria criteria=example.createCriteria();
		
		example.setDistinct(false);
		criteria.andOrderStatusEqualTo(state);
		
		return orderMapper.selectByExample(example);
	}
	
	public List<Dgorder> getbyDgid(String id){
		DgorderExample example=new DgorderExample();
		DgorderExample.Criteria criteria=example.createCriteria();
		
		example.setDistinct(false);
		criteria.andDgIdEqualTo(id);
		
		return orderMapper.selectByExample(example);
	}
	
	public List<Dgorder> getbyDemanderid(String id){
		DgorderExample example=new DgorderExample();
		DgorderExample.Criteria criteria=example.createCriteria();
		
		example.setDistinct(false);
		criteria.andDemanderIdEqualTo(id);
		
		return orderMapper.selectByExample(example);
	}
	
}
