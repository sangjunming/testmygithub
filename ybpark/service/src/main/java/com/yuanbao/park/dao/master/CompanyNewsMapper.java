package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyNews;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompanyNewsMapper extends Mapper<CompanyNews>,MySqlMapper<CompanyNews> {

}