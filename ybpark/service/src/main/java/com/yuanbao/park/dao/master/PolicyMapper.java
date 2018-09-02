package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyAdvice;
import com.yuanbao.park.entity.Policy;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface PolicyMapper  extends Mapper<Policy>,MySqlMapper<Policy> {

}