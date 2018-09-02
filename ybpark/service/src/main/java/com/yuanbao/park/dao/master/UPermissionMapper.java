package com.yuanbao.park.dao.master;

import org.springframework.stereotype.Repository;

import com.yuanbao.park.entity.UPermission;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UPermissionMapper extends Mapper<UPermission>,MySqlMapper<UPermission> {
}