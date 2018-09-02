package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.ServiceActivity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ServiceActivityMapper extends Mapper<ServiceActivity>,MySqlMapper<ServiceActivity> {

}