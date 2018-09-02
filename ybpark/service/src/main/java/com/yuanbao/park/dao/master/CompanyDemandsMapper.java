package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyDemands;
import com.yuanbao.park.entity.CompanyOperateInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompanyDemandsMapper extends Mapper<CompanyDemands>,MySqlMapper<CompanyDemands> {

}