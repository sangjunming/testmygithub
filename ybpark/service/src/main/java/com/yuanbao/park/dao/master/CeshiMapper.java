package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.Ceshi;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


@Repository
public interface CeshiMapper extends Mapper<Ceshi> ,MySqlMapper<Ceshi> {

}