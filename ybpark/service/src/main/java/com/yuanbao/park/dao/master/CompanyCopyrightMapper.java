package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyArchive;
import com.yuanbao.park.entity.CompanyCopyright;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompanyCopyrightMapper extends Mapper<CompanyCopyright>,MySqlMapper<CompanyCopyright> {

}