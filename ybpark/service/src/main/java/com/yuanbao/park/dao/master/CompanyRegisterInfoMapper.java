package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyRegisterInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompanyRegisterInfoMapper extends Mapper<CompanyRegisterInfo>,MySqlMapper<CompanyRegisterInfo> {

}