package com.yuanbao.park.service;

import com.yuanbao.park.common.req.IndustryNewsReqParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;

/**
 * @author: CrazyZhou
 * @description: 行业新闻接口层
 * @date: created in 16:45 2018/6/25
 * @param:
 */
public interface ConIndustryNewsService {
    /**
     * @author: CrazyZhou
     * @description: 获取行业新闻
     * @date: 16:53 2018/6/25
     * @param:  * @param null
     */
    CommonListRespParam getIndustryNewsInfo(IndustryNewsReqParam industryNewsReqParam);
}
