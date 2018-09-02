package com.yuanbao.park.service;

import com.yuanbao.park.common.req.CompanyTalentReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;

/**
 * @author: CrazyZhou
 * @description: 企业人才接口层
 * @date: 2018-06-27 19:05
 * @param:
 */
public interface ConCompanyTalentService {

    /**
     * @author: CrazyZhou
     * @description: 添加企业人才信息
     * @date: 19:18 2018/6/27
     * @param:  * @param null
     * @return:
     */
    BaseRespParam addCompanyTalent(CompanyTalentReqParam companyTalentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 查询园区所有人才信息
     * @date: 19:35 2018/6/27
     * @param:  * @param null
     * @return:
     */
    CommonListRespParam getAllCompannyTalent(CompanyTalentReqParam companyTalentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 删除园区信息
     * @date: 19:38 2018/6/27
     * @param:  * @param null
     * @return:
     */
    BaseRespParam deleteCompannyTalent(Long id);
}
