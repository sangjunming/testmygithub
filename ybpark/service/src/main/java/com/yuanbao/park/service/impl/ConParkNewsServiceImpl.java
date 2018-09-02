package com.yuanbao.park.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.ParkNewsReqParam;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.utils.BasePageRespParamsUtils;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.dao.master.LabelDepotMapper;
import com.yuanbao.park.dao.master.ParkNewsMapper;
import com.yuanbao.park.entity.CompanyNews;
import com.yuanbao.park.entity.LabelDepot;
import com.yuanbao.park.entity.ParkNews;
import com.yuanbao.park.service.ConLabelService;
import com.yuanbao.park.service.ConParkNewsService;
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
 * @Author: xiankang
 * @Date: 2018/7/5 18:49
 * @Description:园区新闻持久化层
 * @Problem:
 * @Return:
 */
@Service
public class ConParkNewsServiceImpl implements ConParkNewsService {
    private static Logger logger = LoggerFactory.getLogger(ConParkNewsServiceImpl.class);

    @Autowired
    private Environment environment;

    @Autowired
    private ParkNewsMapper parkNewsMapper;

    @Autowired
    private ConLabelService conLabelService;

    @Autowired
    private LabelDepotMapper labelDepotMapper;

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 18:49
     * @Description:添加发布园区新闻或添加新闻草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam addParkNewsInfoOrDraft(ParkNewsReqParam parkNewsReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            ParkNews parkNews = new ParkNews();
            //查询标签是否存在,不存在,新建标签,并将标签ID存入新闻表中
            String labelName = parkNewsReqParam.getLabelName();
            String[] split = labelName.split(";");
            for (String name : split) {
                List<LabelDepot> labelDepotList = conLabelService.judgeLabelWhetherExist(parkNewsReqParam.getLabelType(), name);
                if(MyCollectionsUtils.isEmpty(labelDepotList)){
                    //标签不存在,新增此类标签
                    LabelDepot labelDepot = new LabelDepot();
                    labelDepot.setLabelName(name);
                    labelDepot.setLabelType(parkNewsReqParam.getLabelType());
                    labelDepot.setDeleteType(0);
                    labelDepot.setCreateTime(new Date());
                    labelDepot.setUpdateTime(new Date());
                    labelDepotMapper.insertSelective(labelDepot);
                }
            }
            BeanUtils.copyProperties(parkNewsReqParam,parkNews);
            parkNews.setReleasedTime(new Date());
            parkNews.setCreateTime(new Date());
            parkNews.setUpdateTime(new Date());
            parkNews.setParkId(Long.parseLong(environment.getProperty("park.parkId")));
            parkNews.setDeleteType(0);
            int isOk = parkNewsMapper.insertSelective(parkNews);
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
     * @Author: xiankang
     * @Date: 2018/7/5 19:02
     * @Description: 查询园区所有已发布新闻(可以根据条件查询)或所有草稿
     * @Problem:
     * @Return:
     */
    @Override
    public CommonListRespParam getAllParkNewsInfoOrAllDraft(ParkNewsReqParam parkNewsReqParam) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        try {
            //组装查询条件
            Example example = new Example(ParkNews.class);
            Example.Criteria criteria = example.createCriteria();
            //deleteType=0表示已经发布了的企业新闻
            criteria.andEqualTo("newsType",parkNewsReqParam.getNewsType());
            criteria.andEqualTo("deleteType",0);
            criteria.andEqualTo("parkId",Long.parseLong(environment.getProperty("park.parkId")));
            if(MyStringUtils.isNotBlank(parkNewsReqParam.getTitle())){
                criteria.andLike("title","%"+parkNewsReqParam.getTitle()+"%");
            }
            if(MyStringUtils.isNotBlank(parkNewsReqParam.getLikeName())){
                criteria.andLike("title","%"+ parkNewsReqParam.getLikeName() + "%").orLike("content","%"+parkNewsReqParam.getLikeName()+"%");
            }
            if(parkNewsReqParam.getReleaseStartTime() != null | parkNewsReqParam.getReleaseEndTime() != null){
                criteria.andGreaterThanOrEqualTo("releasedTime",parkNewsReqParam.getReleaseStartTime());
            }
            if(parkNewsReqParam.getReleaseEndTime() != null){
                criteria.andLessThanOrEqualTo("releasedTime",parkNewsReqParam.getReleaseEndTime());
            }
            if(MyStringUtils.isNotBlank(parkNewsReqParam.getTag())){
                criteria.andLike("tag","%"+ parkNewsReqParam.getTag() + "%");
            }
            if(parkNewsReqParam.getNewsType().equals(0)){
                example.orderBy("releasedTime").desc();
            }else if(parkNewsReqParam.getNewsType().equals(1)){
                example.orderBy("updateTime").desc();
            }
            //设置分页参数
            PageHelper.startPage(parkNewsReqParam.getPageIndex(),parkNewsReqParam.getPageSize());
            //查询结果
            List<ParkNews> parkNewsList = parkNewsMapper.selectByExample(example);
            BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(parkNewsList);
            commonListRespParam.setBasePageParam(basePageParam);
            commonListRespParam.setDataInfos(parkNewsList);
            return commonListRespParam;
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            commonListRespParam.setResultMsg(e.getMessage());
            commonListRespParam.setResultCode(Message.FAILURE_CODE);
            return commonListRespParam;
        }
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 19:13
     * @Description:发布园区新闻草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam releaseParkNewsInfoDraft(Long id) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",id);
            ParkNews parkNews=new ParkNews();
            parkNews.setReleasedTime(new Date());
            parkNews.setUpdateTime(new Date());
            parkNews.setNewsType(0);
            int isOk=parkNewsMapper.updateByExampleSelective(parkNews,example);
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
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;
        }
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 19:15
     * @Description:修改园区新闻草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam updateParkNewsInfoDraft(ParkNewsReqParam parkNewsReqParam) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",parkNewsReqParam.getId());
            ParkNews parkNews=new ParkNews();
            parkNews.setUpdateTime(new Date());
            BeanUtils.copyProperties(parkNewsReqParam,parkNews);
            int isOk=parkNewsMapper.updateByExampleSelective(parkNews,example);
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
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;
        }
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 19:19
     * @Description:删除园区新闻草稿
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam deleteParkNewsInfoDraft(Long id) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",id);
            ParkNews parkNews=new ParkNews();
            parkNews.setDeleteTime(new Date());
            parkNews.setDeleteType(1);
            int isOk=parkNewsMapper.updateByExampleSelective(parkNews,example);
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
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;
        }
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 19:21
     * @Description:将发布的园区新闻转移至草稿
     * @Problem:
     * @Return:
     */

    @Override
    public BaseRespParam parkNewsToParkNewsInfoDraft(Long id) {
        BaseRespParam baseRespParam=new BaseRespParam();
        try {
            Example example=new Example(CompanyNews.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",id);
            ParkNews parkNews=new ParkNews();
            parkNews.setUpdateTime(new Date());
            parkNews.setNewsType(1);
            int isOk=parkNewsMapper.updateByExampleSelective(parkNews,example);
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
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;
        }
    }
}
