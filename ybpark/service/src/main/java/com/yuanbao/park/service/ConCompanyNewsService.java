package com.yuanbao.park.service;

import com.yuanbao.park.common.req.CompanyNewsReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import org.apache.poi.hssf.record.FilePassRecord;

/**
 * @author: CrazyZhou
 * @description:
 * @date: 2018-06-27 17:17
 * @param:
 */
public interface ConCompanyNewsService {

    /**
     * @author: CrazyZhou
     * @description: 添加企业信息
     * @date: 18:00 2018/6/27
     * @param:  * @param null
     * @return:
     */
    BaseRespParam addCompanyNewsInfoOrDraft(CompanyNewsReqParam companyNewsReqParam);

    /**
     * @author: CrazyZhou
     * @description: 查询园区所有发布企业新闻或所有企业新闻草稿
     * @date: 18:13 2018/6/27
     * @param:  * @param null
     * @return:
     */
    CommonListRespParam getAllCompanyNewsInfoOrDraft(CompanyNewsReqParam companyNewsReqParam);

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 13:24
     * @Description:发布企业新闻草稿
     * @Problem:
     * @Return:
     */
    BaseRespParam releaseCompanyNewsInfoDraft(Long id);
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 13:25
     * @Description:更新企业新闻草稿
     * @Problem:
     * @Return:
     */
    BaseRespParam updateCompanyNewsInfoDraft(CompanyNewsReqParam companyNewsReqParam);
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 13:26
     * @Description:删除企业新闻草稿
     * @Problem:
     * @Return:
     */
    BaseRespParam deleteCompanyNewsInfoDraft(Long id);
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 13:26
     * @Description:取消企业新闻的发布
     * @Problem:
     * @Return:
     */
    BaseRespParam companyNewsToCompanyNewsInfoDraft(Long id);
}
