package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.Area;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface AreaMapper extends Mapper<Area>,MySqlMapper<Area> {

}