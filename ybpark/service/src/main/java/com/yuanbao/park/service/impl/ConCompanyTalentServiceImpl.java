package com.yuanbao.park.service.impl;

import com.yuanbao.park.common.req.CompanyTalentReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.dao.master.CompanyTalentMapper;
import com.yuanbao.park.entity.CompanyTalent;
import com.yuanbao.park.service.ConCompanyTalentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 企业人才持久层
 * @date: 2018-06-27 19:05
 * @param:
 */
@Service
public class ConCompanyTalentServiceImpl implements ConCompanyTalentService {

    @Autowired
    private CompanyTalentMapper companyTalentMapper;

    @Autowired
    private Environment environment;

    /**
     * @author: CrazyZhou
     * @description: 添加企业人才信息
     * @date: 19:19 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyTalent(CompanyTalentReqParam companyTalentReqParam) {
        CompanyTalent companyTalent = new CompanyTalent();
        BeanUtils.copyProperties(companyTalentReqParam,companyTalent);
        if(companyTalentReqParam.getCompanyId() != null){
            companyTalent.setCompanyId(companyTalentReqParam.getCompanyId());
        }else{
            companyTalent.setParkId(Long.parseLong(environment.getProperty("park.parkId")));
        }
        int isOk = companyTalentMapper.insertSelective(companyTalent);
        BaseRespParam baseRespParam = new BaseRespParam();
        if (isOk > 0) {
            return baseRespParam;
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
        }
        return baseRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 查询园区所有人才信息
     * @date: 19:36 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getAllCompannyTalent(CompanyTalentReqParam companyTalentReqParam) {
        Example example = new Example(CompanyTalent.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parkId",companyTalentReqParam.getCompanyId()).andEqualTo("deleteType",0);
        //拼接搜索框的查询条件
        //根据人才名字搜索
        if(MyStringUtils.isNotBlank(companyTalentReqParam.getTalentName())){
            criteria.andLike("talentName","%" + companyTalentReqParam.getTalentName() + "%");
        }
        //根据人才所属企业查询
        if(MyStringUtils.isNotBlank(companyTalentReqParam.getCompanyName())){
            criteria.andLike("companyName","%" + companyTalentReqParam.getCompanyName() + "%");
        }
        //根据人才类别搜索
        if(MyStringUtils.isNotBlank(companyTalentReqParam.getTalentType())){
            criteria.andLike("talentType","%" + companyTalentReqParam.getTalentType() + "%");
        }
        //根据入选人才计划搜索
        if(MyStringUtils.isNotBlank(companyTalentReqParam.getTalentPlaned())){
            criteria.andLike("talentPlaned","%" + companyTalentReqParam.getTalentPlaned() + "%");
        }
        List<CompanyTalent> companyTalentList = companyTalentMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyTalentList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 删除园区人才信息
     * @date: 19:39 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @Override
    public BaseRespParam deleteCompannyTalent(Long id) {
        Example example = new Example(CompanyTalent.class);
        example.createCriteria().andEqualTo("id",id);
        CompanyTalent companyTalent = new CompanyTalent();
        companyTalent.setDeleteType(1);
        companyTalent.setUpdateTime(new Date());
        companyTalent.setDeleteTime(new Date());
        int isOk = companyTalentMapper.updateByExampleSelective(companyTalent, example);
        BaseRespParam baseRespParam = new BaseRespParam();
        if (isOk > 0) {
            baseRespParam.setResultMsg(MessageEnum.SUCCESS + "");

        } else {
            baseRespParam.setResultMsg(MessageEnum.FAILURE + "");
        }
        return baseRespParam;
    }
}
