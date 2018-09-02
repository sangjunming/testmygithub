package com.yuanbao.park.dao.master;

import org.springframework.stereotype.Repository;

import com.yuanbao.park.entity.URole;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface URoleMapper extends Mapper<URole>,MySqlMapper<URole>{
}