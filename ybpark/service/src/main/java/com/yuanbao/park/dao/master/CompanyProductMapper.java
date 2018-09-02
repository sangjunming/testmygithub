package com.yuanbao.park.dao.master;

import com.yuanbao.park.entity.CompanyProduct;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface CompanyProductMapper extends Mapper<CompanyProduct>,MySqlMapper<CompanyProduct> {

    /**
     * @author: CrazyZhou
     * @description: 根据条件查询企业产品信息列表
     * @date: 11:58 2018/6/26
     * @param:  * @param null
     * @return:
     */
    List<CompanyProduct> getProductList(CompanyProduct companyProduct);
}