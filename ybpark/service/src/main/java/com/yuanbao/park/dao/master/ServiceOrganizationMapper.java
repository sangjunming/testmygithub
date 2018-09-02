package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.ServiceOrganization;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ServiceOrganizationMapper extends Mapper<ServiceOrganization>,MySqlMapper<ServiceOrganization> {

}