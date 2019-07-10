package com.zhang.zdg2.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.zdg2.dao.RemarkMapper;
import com.zhang.zdg2.model.Remark;
import com.zhang.zdg2.model.RemarkExample;

@Service
public class RemarkService {
	
	@Resource
	RemarkMapper remarkMapper;
	
	public int createRemark(Remark remark) {
		return remarkMapper.insertSelective(remark);
	}
	
	public List<Remark> getBydg(String id){
		RemarkExample example=new RemarkExample();
		
		RemarkExample.Criteria criteria=example.createCriteria();
		
		criteria.andDgIdEqualTo(id);
		
		return remarkMapper.selectByExample(example);
	}
}
