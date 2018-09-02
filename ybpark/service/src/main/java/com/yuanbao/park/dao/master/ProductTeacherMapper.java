package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.ProductTeacher;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
@Repository
public interface ProductTeacherMapper extends Mapper<ProductTeacher>,MySqlMapper<ProductTeacher> {

}