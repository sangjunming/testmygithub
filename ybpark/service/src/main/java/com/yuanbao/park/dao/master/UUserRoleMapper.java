package com.yuanbao.park.dao.master;

import org.springframework.stereotype.Repository;

import com.yuanbao.park.entity.UUserRole;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UUserRoleMapper  extends Mapper<UUserRole>,MySqlMapper<UUserRole>{
}