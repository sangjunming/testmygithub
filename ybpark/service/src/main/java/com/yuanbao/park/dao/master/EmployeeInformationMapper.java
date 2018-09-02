package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyAdvice;
import com.yuanbao.park.entity.EmployeeInformation;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface EmployeeInformationMapper extends Mapper<EmployeeInformation>,MySqlMapper<EmployeeInformation> {

}