package com.yuanbao.park.dao.master;

import org.springframework.stereotype.Repository;

import com.yuanbao.park.entity.UUser;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UUserMapper extends Mapper<UUser>,MySqlMapper<UUser>{
	
	public UUser selectUUserByName(String name);
}