package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyFinancing;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompanyFinancingMapper extends Mapper<CompanyFinancing>,MySqlMapper<CompanyFinancing> {

}