package com.yuanbao.park.dao.master;

import org.springframework.stereotype.Repository;

import com.yuanbao.park.entity.URolePermission;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface URolePermissionMapper extends Mapper<URolePermission>,MySqlMapper<URolePermission>{
}