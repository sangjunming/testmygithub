package com.yuanbao.park.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanbao.park.dao.master.CeshiMapper;
import com.yuanbao.park.entity.Ceshi;
import com.yuanbao.park.service.TestService;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private CeshiMapper ceshiMapper; // 主数据源

	@Override
	public List<Ceshi> findCeshiList() {
		// TODO Auto-generated method stub
		/*CeshiExample example = new CeshiExample();
		Criteria criteria = example.createCriteria();  
        criteria.andTestEqualTo("123");*/
        Example example = new Example(Ceshi.class);
        example.createCriteria().andEqualTo("test","123");

        return ceshiMapper.selectByExample(example);
	}

	@Override
	public Ceshi insert(Ceshi ceshi) {
		ceshiMapper.insertSelective(ceshi);
        Ceshi ceshi1 = new Ceshi();
        ceshi1.setId(ceshi.getId());
        return ceshi1;
	}

}
