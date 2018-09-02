package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.Competence;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CompetenceMapper  extends Mapper<Competence>,MySqlMapper<Competence> {

}