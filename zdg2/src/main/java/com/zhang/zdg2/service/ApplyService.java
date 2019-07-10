package com.zhang.zdg2.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhang.zdg2.dao.ApplyMapper;
import com.zhang.zdg2.model.Apply;
import com.zhang.zdg2.model.ApplyExample;

@Service
public class ApplyService {

	@Resource
	ApplyMapper applyMapper;

	public int createApply(Apply apply, String id) {
		apply.setDgId(id);
		apply.setApplyState("applying");
		return applyMapper.insert(apply);
	}

	public int updateApply(Apply apply) {
		ApplyExample example = new ApplyExample();

		ApplyExample.Criteria criteria = example.createCriteria();

		criteria.andDgIdEqualTo(apply.getDgId());
		criteria.andOrderIdEqualTo(apply.getOrderId());

		apply.setDgId(null);

		apply.setOrderId(null);

		return applyMapper.updateByExampleSelective(apply, example);
	}

	public List<Apply> getApplyByOrder(String orderId) {
		ApplyExample example = new ApplyExample();
		ApplyExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		
		return applyMapper.selectByExample(example);
	}
	
	
	
	
}
