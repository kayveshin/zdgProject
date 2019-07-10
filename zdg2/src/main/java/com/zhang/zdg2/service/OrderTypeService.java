package com.zhang.zdg2.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.zdg2.dao.DgitypeMapper;
import com.zhang.zdg2.dao.OrdertypeMapper;
import com.zhang.zdg2.model.Dgitype;
import com.zhang.zdg2.model.Ordertype;

@Service
public class OrderTypeService {
	
	@Resource
	OrdertypeMapper ordertypeMapper;
	
	@Resource
	DgitypeMapper dgitypeMapper;
	
	public List<Ordertype> getList(){
		return ordertypeMapper.selectByExample(null);
	}
	
	public int addlist(List<Dgitype> list ) {
		int result=0;
		for (Dgitype dgitype : list) {
			result+=dgitypeMapper.insert(dgitype);
		}
		return result;
	}
	
	
}
