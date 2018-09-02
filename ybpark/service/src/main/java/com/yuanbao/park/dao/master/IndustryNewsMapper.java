package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.IndustryNews;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface IndustryNewsMapper extends Mapper<IndustryNews>,MySqlMapper<IndustryNews> {

}