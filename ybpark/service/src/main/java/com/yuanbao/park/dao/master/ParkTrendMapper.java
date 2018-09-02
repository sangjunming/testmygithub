package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.ParkTrend;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ParkTrendMapper extends Mapper<ParkTrend>,MySqlMapper<ParkTrend> {

}