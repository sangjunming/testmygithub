package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CollectCompany;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CollectCompanyMapper extends Mapper<CollectCompany>,MySqlMapper<CollectCompany> {

}