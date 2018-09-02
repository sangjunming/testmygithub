package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.ParkApplication;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ParkApplicationMapper extends Mapper<ParkApplication>,MySqlMapper<ParkApplication> {

}