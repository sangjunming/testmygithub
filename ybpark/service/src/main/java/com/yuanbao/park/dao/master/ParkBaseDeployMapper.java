package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyAdvice;
import com.yuanbao.park.entity.ParkBaseDeploy;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ParkBaseDeployMapper extends Mapper<ParkBaseDeploy>,MySqlMapper<ParkBaseDeploy> {

}