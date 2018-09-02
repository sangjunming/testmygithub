package com.yuanbao.park.service;

import com.yuanbao.park.common.resultUtils.ResultData;

/**
 * @author: CrazyZhou
 * @description: 园区图谱接口层
 * @date: 2018-07-02 10:19
 * @param:
 */
public interface ConParkIconService {

    /**
     * @author: CrazyZhou
     * @description: 统计园区各类型企业数量
     * @date: 15:42 2018/7/2
     * @param:  * @param null
     * @return:
     */
    ResultData countCompanyTypeAmount();
}
