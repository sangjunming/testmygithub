package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.Statistics;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface StatisticsMapper extends Mapper<Statistics>,MySqlMapper<Statistics> {

}