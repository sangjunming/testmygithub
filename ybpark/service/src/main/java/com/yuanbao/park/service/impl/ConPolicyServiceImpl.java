package com.yuanbao.park.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.PolicyReqParam;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.respPojo.CompanyInfoData;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.utils.BasePageRespParamsUtils;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.dao.master.CompanyMapper;
import com.yuanbao.park.dao.master.PolicyCompanyAreaMapper;
import com.yuanbao.park.dao.master.PolicyMapper;
import com.yuanbao.park.entity.Company;
import com.yuanbao.park.entity.Policy;
import com.yuanbao.park.entity.PolicyCompanyArea;
import com.yuanbao.park.service.ConPolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiankang
 * @Date: 2018/7/6 11:36
 * @Description:政策信息持久化层
 * @Problem:
 * @Return:
 */
@Service
public class ConPolicyServiceImpl implements ConPolicyService {
    private static Logger logger = LoggerFactory.getLogger(ConPolicyServiceImpl.class);
    @Autowired
    private  PolicyMapper policyMapper;

    @Autowired
    private PolicyCompanyAreaMapper policyCompanyAreaMapper;

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * @Author: xiankang
     * @Date: 2018/7/6 11:36
     * @Description:政策信息查询（可添加条件）
     * @Problem:
     * @Return:
     */
    @Override
    public CommonListRespParam getAllPolicyInfo(PolicyReqParam policyReqParam) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        try {
            Example example = new Example(Policy.class);
            Example.Criteria criteria = example.createCriteria();
            //拼接查询条件
            criteria.andEqualTo("id", policyReqParam.getId()).andEqualTo("deleteType", 0);
            if (MyStringUtils.isNotBlank(policyReqParam.getTitle())) {
                criteria.andLike("title", "%" + policyReqParam.getTitle() + "%");
            }

            if (MyStringUtils.isNotBlank(policyReqParam.getIssued())) {
                criteria.andEqualTo("issued", policyReqParam.getIssued());
            }

            if (policyReqParam.getReleaseStartTime() != null) {
                criteria.andGreaterThanOrEqualTo("releaseTime", policyReqParam.getReleaseStartTime());
            }

            if (policyReqParam.getReleaseEndTime() != null) {
                criteria.andLessThanOrEqualTo("releaseTime", policyReqParam.getReleaseEndTime());

            }

            if (MyStringUtils.isNotBlank(policyReqParam.getLable())) {
                criteria.andLike("lable", "%" + policyReqParam.getLable() + "%");
            }

            if (MyStringUtils.isNotBlank(policyReqParam.getLikeName())) {
                criteria.andLike("lable", "%" + policyReqParam.getLikeName() + "%").orLike("title", "%" + policyReqParam.getLikeName() + "%").orLike("detail", "%" + policyReqParam.getLikeName() + "%");
            }
            example.orderBy("releaseTime").desc();
            PageHelper.startPage(policyReqParam.getStartIndex(), policyReqParam.getPageSize());
            List<Policy> policyList = policyMapper.selectByExample(example);
            BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(policyList);
            commonListRespParam.setBasePageParam(basePageParam);
            return commonListRespParam;
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            commonListRespParam.setResultCode(Message.FAILURE_CODE);
            commonListRespParam.setResultMsg(Message.FAILURE);
            return commonListRespParam;
        }
    }
    /**
     * @Author: xiankang
     * @Date: 2018/7/6 15:41
     * @Description:政策适应企业查询
     * @Problem:
     * @Return:
     */
    @Override
    public CommonListRespParam getCompanyNameInfo(Long id) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        try {
            Example policyCompanyAreaExample=new Example(PolicyCompanyArea.class);
            Example.Criteria policyCompanyAreaExamplecriteria = policyCompanyAreaExample.createCriteria();
            policyCompanyAreaExamplecriteria.andEqualTo("policyId",id);
            List<PolicyCompanyArea> policyCompanyAreas = policyCompanyAreaMapper.selectByExample(policyCompanyAreaExample);
            List<Company> companyList=new ArrayList<Company>();
            for (int i=0;i<policyCompanyAreas.size();i++){
                Long companyId=policyCompanyAreas.get(i).getCompanyId();
                Company company=companyMapper.selectByPrimaryKey(companyId);
                companyList.add(company);
            }
            List<CompanyInfoData> companyInfoData=new ArrayList<CompanyInfoData>();
            BeanUtils.copyProperties(companyList,companyInfoData);
            commonListRespParam.setDataInfos(companyInfoData);
            return commonListRespParam;
        } catch (BeansException e) {
            logger.info(e.getMessage(), e);
            commonListRespParam.setResultCode(Message.FAILURE_CODE);
            commonListRespParam.setResultMsg(Message.FAILURE);
            return commonListRespParam;
        }

    }
}
