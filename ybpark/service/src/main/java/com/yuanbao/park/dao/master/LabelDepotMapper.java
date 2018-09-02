package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.LabelDepot;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface LabelDepotMapper extends Mapper<LabelDepot>,MySqlMapper<LabelDepot> {

}