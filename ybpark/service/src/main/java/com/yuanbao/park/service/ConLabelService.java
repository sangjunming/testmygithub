package com.yuanbao.park.service;

import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.entity.LabelDepot;

import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 标签信息接口
 * @date: 2018-06-28 14:33
 * @param:
 */
public interface ConLabelService {

    /**
     * @author: CrazyZhou
     * @description: 获取标签列表接口
     * @date: 14:44 2018/6/28
     * @param:  * @param null
     * @return:
     */
    CommonListRespParam getLabelInfoList(Integer labelType);

    /**
     * @author: CrazyZhou
     * @description: 根据标签名与标签类型判断标签是否存在
     * @date: 14:13 2018/7/9
     * @param:  * @param null
     * @return:
     */
    List<LabelDepot> judgeLabelWhetherExist(Integer labelType, String labelName);
}
