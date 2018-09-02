package com.yuanbao.park.service.impl;

import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.dao.master.LabelDepotMapper;
import com.yuanbao.park.entity.LabelDepot;
import com.yuanbao.park.service.ConLabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 标签信息持久层
 * @date: 2018-06-28 14:35
 * @param:
 */
@Service
public class ConLabelServiceImpl implements ConLabelService {

    private static Logger logger = LoggerFactory.getLogger(ConLabelServiceImpl.class);

    @Autowired
    private LabelDepotMapper labelDepotMapper;

    /**
     * @author: CrazyZhou
     * @description: 查询标签列表的持久层
     * @date: 14:45 2018/6/28
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getLabelInfoList(Integer labelType) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        try {
            Example example = new Example(LabelDepot.class);
            example.createCriteria().andEqualTo("labelType", labelType).andEqualTo("deleteType", 0);
            List<LabelDepot> labelDepotList = labelDepotMapper.selectByExample(example);
            commonListRespParam.setDataInfos(labelDepotList);
            commonListRespParam.setResultCode(Message.SUCCESS);
            commonListRespParam.setResultMsg(Message.SUCCESS_CODE);
            return commonListRespParam;
        } catch (Exception e) {
            logger.info(e.getMessage());
            commonListRespParam.setResultCode(Message.FAILURE_CODE);
            commonListRespParam.setResultMsg(e.getMessage());
            return commonListRespParam;
        }
    }

    /**
     * @author: CrazyZhou
     * @description: 根据标签名与标签类型判断标签是否存在
     * @date: 14:13 2018/7/9
     * @param: * @param null
     * @return:
     */
    @Override
    public List<LabelDepot> judgeLabelWhetherExist(Integer labelType, String labelName) {
        Example example = new Example(LabelDepot.class);
        example.createCriteria().andEqualTo("labelName", labelName).andEqualTo("labelType", labelType);
        List<LabelDepot> labelDepotList = labelDepotMapper.selectByExample(example);
        return labelDepotList;
    }

}
