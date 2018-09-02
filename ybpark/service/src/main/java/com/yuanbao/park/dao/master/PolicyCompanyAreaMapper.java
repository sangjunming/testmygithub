package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.PolicyCompanyArea;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface PolicyCompanyAreaMapper extends Mapper<PolicyCompanyArea>,MySqlMapper<PolicyCompanyArea> {

}