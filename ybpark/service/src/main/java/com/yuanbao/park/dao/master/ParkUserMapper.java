package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.ParkUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ParkUserMapper extends Mapper<ParkUser>,MySqlMapper<ParkUser> {

}