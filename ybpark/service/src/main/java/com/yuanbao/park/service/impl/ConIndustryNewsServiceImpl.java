package com.yuanbao.park.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.IndustryNewsReqParam;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.respPojo.ConLiveIndustryNewsInfoData;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.BasePageRespParamsUtils;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.dao.master.IndustryNewsMapper;
import com.yuanbao.park.entity.IndustryNews;
import com.yuanbao.park.service.ConIndustryNewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 行业新闻持久层
 * @date: created in 16:45 2018/6/25
 * @param:
 */
@Service
public class ConIndustryNewsServiceImpl implements ConIndustryNewsService {

    @Autowired
    private IndustryNewsMapper industryNewsMapper;

    /**
     * @author: CrazyZhou
     * @description: 根据条件查询行业新闻
     * @date: 16:54 2018/6/25
     * @param: * @param null
     */
    @Override
    public CommonListRespParam getIndustryNewsInfo(IndustryNewsReqParam industryNewsReqParam) {
        //拼接查询条件
        Example industryNewsExample = new Example(IndustryNews.class);
        Example.Criteria industryNewsExampleCriteria = industryNewsExample.createCriteria();
        if (MyStringUtils.isNotBlank(industryNewsReqParam.getIndustryName())) {
            industryNewsExampleCriteria.andLike("industryName", "%" + industryNewsReqParam.getIndustryName() + "%");
        }
        if (MyStringUtils.isNotBlank(industryNewsReqParam.getLikeName())) {
            industryNewsExampleCriteria.andLike("title", "%" + industryNewsReqParam.getLikeName() + "%");
            industryNewsExample.or().andLike("content", "%" + industryNewsReqParam.getLikeName() + "%");
        }
        if (industryNewsReqParam.getReleasedStartTime() != null) {
            industryNewsExampleCriteria.andGreaterThanOrEqualTo("releaseTime", industryNewsReqParam.getReleasedStartTime());
        }
        if(industryNewsReqParam.getReleaseEndTime() != null){
            industryNewsExampleCriteria.andLessThanOrEqualTo("releaseTime",industryNewsReqParam.getReleaseEndTime());
        }
        //设置排序
        industryNewsExample.orderBy("createTime").desc().orderBy("releaseTime").desc();
        //设置分页参数
        PageHelper.startPage(industryNewsReqParam.getPageIndex(), industryNewsReqParam.getPageSize());
        List<IndustryNews> industryNewsList = industryNewsMapper.selectByExample(industryNewsExample);
        //根据查询结果返回分页信息
        BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(industryNewsList);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setBasePageParam(basePageParam);
        List<ConLiveIndustryNewsInfoData> conLiveIndustryNewsInfoDataList = new ArrayList<ConLiveIndustryNewsInfoData>();
        if (MyCollectionsUtils.isNotEmpty(industryNewsList)) {
            for (IndustryNews industryNews : industryNewsList) {
                ConLiveIndustryNewsInfoData conLiveIndustryNewsInfoData = new ConLiveIndustryNewsInfoData();
                BeanUtils.copyProperties(industryNews, conLiveIndustryNewsInfoData);
                conLiveIndustryNewsInfoDataList.add(conLiveIndustryNewsInfoData);
            }
        }
        commonListRespParam.setDataInfos(conLiveIndustryNewsInfoDataList);
        return commonListRespParam;
    }
}
