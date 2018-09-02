package com.yuanbao.park.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.CompanyNewsReqParam;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.BasePageRespParamsUtils;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.controller.ConCompanyServerAndActivitiesController;
import com.yuanbao.park.dao.master.CompanyNewsMapper;
import com.yuanbao.park.dao.master.LabelDepotMapper;
import com.yuanbao.park.entity.CompanyNews;
import com.yuanbao.park.entity.LabelDepot;
import com.yuanbao.park.service.ConCompanyNewsService;
import com.yuanbao.park.service.ConLabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 企业新闻持久层
 * @date: 2018-06-27 17:17
 * @param:
 */
@Service
public class ConCompanyNewsServiceImpl implements ConCompanyNewsService {
    private static Logger logger = LoggerFactory.getLogger(ConCompanyNewsServiceImpl.class);

    @Autowired
    private CompanyNewsMapper companyNewsMapper;

    @Autowired
    private ConLabelService conLabelService;

    @Autowired
    private LabelDepotMapper labelDepotMapper;

    @Autowired
    private Environment environment;

    /**
     * @author: CrazyZhou
     * @description: 正常添加企业新闻
     * @date: 18:01 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyNewsInfoOrDraft(CompanyNewsReqParam companyNewsReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            CompanyNews companyNews = new CompanyNews();
            //查询标签是否存在,不存在,新建标签,并将标签ID存入新闻表中
            String labelName = companyNewsReqParam.getLabelName();
            String[] split = labelName.split(";");
            for (String name : split) {
                List<LabelDepot> labelDepotList = conLabelService.judgeLabelWhetherExist(companyNewsReqParam.getLabelType(), name);
                if(MyCollectionsUtils.isEmpty(labelDepotList)){
                    //标签不存在,新增此类标签
                    LabelDepot labelDepot = new LabelDepot();
                    labelDepot.setLabelName(name);
                    labelDepot.setLabelType(companyNewsReqParam.getLabelType());
                    labelDepot.setDeleteType(0);
                    labelDepot.setCreateTime(new Date());
                    labelDepot.setUpdateTime(new Date());
                    labelDepotMapper.insertSelective(labelDepot);
                }
            }
            BeanUtils.copyProperties(companyNewsReqParam,companyNews);
            companyNews.setCreateTime(new Date());
            companyNews.setReleasedTime(new Date());
            companyNews.setUpdateTime(new Date());
            companyNews.setDeleteType(0);
            int isOk = companyNewsMapper.insertSelective(companyNews);
            if (isOk > 0) {
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
                return baseRespParam;
            }

        } catch (BeansException e) {
            logger.info(e.getMessage(), e);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;

        }
    }

    /**
     * @author: CrazyZhou
     * @description: 查询园区所有发布企业新闻或所有企业新闻草稿
     * @date: 18:14 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getAllCompanyNewsInfoOrDraft(CompanyNewsReqParam companyNewsReqParam) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        try {
            //组装查询条件
            Example example = new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("deleteType",0);
            criteria.andEqualTo("",companyNewsReqParam.getNewsType());
            if(MyStringUtils.isNotBlank(companyNewsReqParam.getCompanyName())){
                criteria.andLike("companyName","%"+companyNewsReqParam.getCompanyName()+"%");
            }
            if(MyStringUtils.isNotBlank(companyNewsReqParam.getLikeName())){
                criteria.andLike("title","%"+companyNewsReqParam.getLikeName()+"%").andLike("content","%"+companyNewsReqParam.getContent()+"%");
            }
            if(companyNewsReqParam.getReleaseStartTime() != null){
                criteria.andGreaterThanOrEqualTo("releasedTime",companyNewsReqParam.getReleaseStartTime());
            }
            if(companyNewsReqParam.getReleaseEndTime() != null){
                criteria.andLessThanOrEqualTo("releasedTime",companyNewsReqParam.getReleaseEndTime());
            }
            if(MyStringUtils.isNotBlank(companyNewsReqParam.getTag())){
                criteria.andLike("tag","%" + companyNewsReqParam.getTag() + "%");
            }
            if(companyNewsReqParam.getNewsType().equals(0)){
                example.orderBy("releasedTime").desc();
            }else if(companyNewsReqParam.getNewsType().equals(1)){
                example.orderBy("updateTime").desc();
            }
            //设置分页参数
            PageHelper.startPage(companyNewsReqParam.getPageIndex(),companyNewsReqParam.getPageSize());
            //查询结果
            List<CompanyNews> companyNewsList = companyNewsMapper.selectByExample(example);
            BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(companyNewsList);
            commonListRespParam.setBasePageParam(basePageParam);
            commonListRespParam.setDataInfos(companyNewsList);
            return commonListRespParam;
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            commonListRespParam.setResultMsg(Message.FAILURE);
            commonListRespParam.setResultCode(Message.FAILURE_CODE);
            return commonListRespParam;
        }
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 13:28
     * @Description:发布企业新闻草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam releaseCompanyNewsInfoDraft(Long id) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",id);
            CompanyNews companyNews=new CompanyNews();
            companyNews.setUpdateTime(new Date());
            companyNews.setNewsType(0);
            int isOk=companyNewsMapper.updateByExampleSelective(companyNews,example);
            if (isOk > 0) {
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
                return baseRespParam;
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(e.getMessage());
            return baseRespParam;
        }

    }
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 13:59
     * @Description:修改园区新闻草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam updateCompanyNewsInfoDraft(CompanyNewsReqParam companyNewsReqParam) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",companyNewsReqParam.getId());
            CompanyNews companyNews=new CompanyNews();
            companyNews.setUpdateTime(new Date());
            BeanUtils.copyProperties(companyNewsReqParam,companyNews);
            int isOk=companyNewsMapper.updateByExampleSelective(companyNews,example);
            if (isOk > 0) {
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
                return baseRespParam;
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(e.getMessage());
            return baseRespParam;
        }

    }
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 14:29
     * @Description:删除园区新闻草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam deleteCompanyNewsInfoDraft(Long id) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",id);
            CompanyNews companyNews=new CompanyNews();
            companyNews.setDeleteTime(new Date());
            companyNews.setDeleteType(1);
            int isOk=companyNewsMapper.updateByExampleSelective(companyNews,example);
            if (isOk > 0) {
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
                return baseRespParam;
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(e.getMessage());
            return baseRespParam;
        }
    }
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 14:30
     * @Description:发布的园区新闻转入草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam companyNewsToCompanyNewsInfoDraft(Long id) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",id);
            CompanyNews companyNews=new CompanyNews();
            companyNews.setUpdateTime(new Date());
            companyNews.setNewsType(1);
            int isOk=companyNewsMapper.updateByExampleSelective(companyNews,example);
            if (isOk > 0) {
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
                return baseRespParam;
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(e.getMessage());
            return baseRespParam;
        }
    }
}
