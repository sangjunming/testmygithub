package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyArchive;
import com.yuanbao.park.entity.CompanyServer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompanyServerMapper extends Mapper<CompanyServer>,MySqlMapper<CompanyServer> {

}