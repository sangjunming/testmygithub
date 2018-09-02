package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.Park;
import com.yuanbao.park.entity.ParkNews;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ParkNewsMapper extends Mapper<ParkNews>,MySqlMapper<ParkNews> {

}