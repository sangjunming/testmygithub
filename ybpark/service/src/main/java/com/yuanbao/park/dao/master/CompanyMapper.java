package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.Company;
import com.yuanbao.park.entity.CompanyArchive;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompanyMapper  extends Mapper<Company>,MySqlMapper<Company> {

}