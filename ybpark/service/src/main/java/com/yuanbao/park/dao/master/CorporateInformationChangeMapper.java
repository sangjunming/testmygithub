package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CorporateInformationChange;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface CorporateInformationChangeMapper  extends Mapper<CorporateInformationChange>,MySqlMapper<CorporateInformationChange> {

}