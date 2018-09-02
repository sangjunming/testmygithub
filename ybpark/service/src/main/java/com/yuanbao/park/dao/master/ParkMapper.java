package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.Park;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ParkMapper  extends Mapper<Park>,MySqlMapper<Park> {

}