package com.yuanbao.park.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.*;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.respPojo.CompanyNewsResParam;
import com.yuanbao.park.common.respPojo.ConCompanyProductInfoData;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.utils.*;
import com.yuanbao.park.dao.master.*;
import com.yuanbao.park.entity.*;
import com.yuanbao.park.service.ConCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 产品相关信息持久层
 * @date: 2018-06-25 19:46
 * @param:
 */
@Service
public class ConCompanyServiceImpl implements ConCompanyService {

    private static Logger logger = LoggerFactory.getLogger(ConCompanyServiceImpl.class);

    @Autowired
    private CompanyProductMapper companyProductMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyFinancingMapper companyFinancingMapper;

    @Autowired
    private ShareholderInformationMapper shareholderInformationMapper;

    @Autowired
    private EmployeeInformationMapper employeeInformationMapper;

    @Autowired
    private CompanyTalentMapper companyTalentMapper;

    @Autowired
    private ProductTeacherMapper productTeacherMapper;

    @Autowired
    private CompanyPatentMapper companyPatentMapper;

    @Autowired
    private CompanyNewsMapper companyNewsMapper;

    @Autowired
    private CompanyArchiveMapper companyArchiveMapper;

    @Autowired
    private CompanyOperateInfoMapper companyOperateInfoMapper;

    @Autowired
    private CompanyTalentStatMapper companyTalentStatMapper;

    @Autowired
    private CompanyCopyrightMapper companyCopyrightMapper;

    @Autowired
    private CompanyDemandsMapper companyDemandsMapper;

    @Autowired
    private CompanyRegisterInfoMapper companyRegisterInfoMapper;

    @Autowired
    private Environment environment;

    /**
     * @author: CrazyZhou
     * @description: 查询企业基本信息
     * @date: 16:08 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getOneCompanyInfo(Long companyId, Long parkId) {
        Example companyExample = new Example(Company.class);
        companyExample.excludeProperties("entryStartDate", "entryEndDate");
        companyExample.createCriteria().andEqualTo("id", companyId).andEqualTo("parkId", parkId);
        List<Company> companyList = companyMapper.selectByExample(companyExample);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业基本信息
     * @date: 10:29 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateOneCompanyInfo(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            //修改企业基本信息
            Example companyExample = new Example(Company.class);
            companyExample.createCriteria().andEqualTo("id", companyBasicInfoReqParam.getId());
            Company company = new Company();
            BeanUtils.copyProperties(companyBasicInfoReqParam, company);
            company.setUpdateTime(new Date());
            int isOk = companyMapper.updateByExampleSelective(company, companyExample);
            if (isOk > 0) {
                baseRespParam.setResultMsg(Message.SUCCESS);
                baseRespParam.setResultCode(Message.SUCCESS_CODE);
            } else {
                baseRespParam.setResultMsg(Message.FAILURE);
                baseRespParam.setResultCode(Message.FAILURE_CODE);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            baseRespParam.setResultMsg(e.getMessage());
            baseRespParam.setResultCode(Message.FAILURE_CODE);
        }
        return baseRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 获取企业资料
     * @date: 10:23 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyArchiveInfo(Long companyId) {
        Example example = new Example(CompanyArchive.class);
        example.createCriteria().andEqualTo("companyId", companyId).andEqualTo("deleteType", 0);
        List<CompanyArchive> companyArchiveList = companyArchiveMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyArchiveList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业资料信息
     * @date: 10:45 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam deleteCompanyArchiveInfo(Long id) {
        BaseRespParam baseRespParam = new BaseRespParam();
        Example example = new Example(CompanyArchive.class);
        example.createCriteria().andEqualTo("id", id);
        CompanyArchive companyArchive = new CompanyArchive();
        companyArchive.setDeleteType(1);
        companyArchive.setUpdateTime(new Date());
        companyArchive.setDeleteTime(new Date());
        int isOk = companyArchiveMapper.updateByExampleSelective(companyArchive, example);
        if (isOk > 0) {
            return baseRespParam;
        } else {
            baseRespParam.setResultMsg(Message.FAILURE);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
        }
        return baseRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业资料信息
     * @date: 10:41 2018/7/8
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyArchiveInfo(CompanyArchiveInfoReqParam companyArchiveInfoReqParam) {
        CompanyArchive companyArchive = new CompanyArchive();
        BeanUtils.copyProperties(companyArchiveInfoReqParam, companyArchive);
        companyArchive.setCreateTime(new Date());
        companyArchive.setUpdateTime(new Date());
        companyArchive.setDeleteType(0);
        int isOk = companyArchiveMapper.insertSelective(companyArchive);
        BaseRespParam baseRespParam = new BaseRespParam();
        if (isOk > 0) {
            return baseRespParam;
        } else {
            baseRespParam.setResultMsg(Message.FAILURE);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
        }
        return baseRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 查看企业经营信息
     * @date: 11:07 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyOperateInfo(Long companyId) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        Example example = new Example(CompanyOperateInfo.class);
        example.createCriteria().andEqualTo("companyId", companyId).andEqualTo("deleteType", 0);
        List<CompanyOperateInfo> companyOperateInfoList = companyOperateInfoMapper.selectByExample(example);
        commonListRespParam.setDataInfos(companyOperateInfoList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业经营信息
     * @date: 10:54 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyOperateInfo(CompanyOperateInfoReqParam companyOperateInfoReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        CompanyOperateInfo companyOperateInfo = new CompanyOperateInfo();
        BeanUtils.copyProperties(companyOperateInfoReqParam, companyOperateInfo);
        companyOperateInfo.setDeleteType(0);
        companyOperateInfo.setCreateTime(new Date());
        companyOperateInfo.setUpdateTime(new Date());
        int isOk = companyOperateInfoMapper.insertSelective(companyOperateInfo);
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
     * @description: 修改企业经营信息
     * @date: 11:01 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyOperateInfo(CompanyOperateInfoReqParam companyOperateInfoReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        Example example = new Example(CompanyOperateInfo.class);
        example.createCriteria().andEqualTo("companyId", companyOperateInfoReqParam.getCompanyId());
        CompanyOperateInfo companyOperateInfo = new CompanyOperateInfo();
        BeanUtils.copyProperties(companyOperateInfoReqParam, companyOperateInfo);
        companyOperateInfo.setUpdateTime(new Date());
        int isOk = companyOperateInfoMapper.updateByExampleSelective(companyOperateInfo, example);
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
     * @description: 查询企业相关融资信息
     * @date: 18:43 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyFinancingInfo(Long companyId) {
        Example example = new Example(CompanyFinancing.class);
        example.createCriteria().andEqualTo("companyId", companyId).andEqualTo("deleteType", 0);
        example.orderBy("createTime");
        List<CompanyFinancing> companyFinancingList = companyFinancingMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyFinancingList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业融资信息
     * @date: 18:53 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyFinancingInfo(CompanyFinancingReqParam companyFinancingReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        CompanyFinancing companyFinancing = new CompanyFinancing();
        BeanUtils.copyProperties(companyFinancingReqParam, companyFinancing);
        companyFinancing.setDeleteType(0);
        companyFinancing.setCreateTime(new Date());
        companyFinancing.setUpdateTime(new Date());
        int isOk = companyFinancingMapper.insertSelective(companyFinancing);
        if (isOk > 0) {
            //将融资轮次保存到company表中
            Company company = new Company();
            company.setRoundNum(companyFinancingReqParam.getRoundNum());
            Example example = new Example(Company.class);
            example.createCriteria().andEqualTo("companyId", companyFinancingReqParam.getCompanyId());
            companyMapper.updateByExampleSelective(company, example);
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
        }
        return baseRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业融资信息
     * @date: 19:02 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam delCompanyFinancingInfo(Long companyId) {
        BaseRespParam baseRespParam = new BaseRespParam();
        Example example = new Example(CompanyFinancing.class);
        example.createCriteria().andEqualTo("companyId", companyId);
        CompanyFinancing companyFinancing = new CompanyFinancing();
        companyFinancing.setDeleteType(1);
        companyFinancing.setUpdateTime(new Date());
        companyFinancing.setDeleteTime(new Date());
        int isOk = companyFinancingMapper.updateByExampleSelective(companyFinancing, example);
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
     * @description: 获取企业人才统计信息
     * @date: 11:11 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyTalentStat(Long companyId) {
        Example example = new Example(CompanyTalentStat.class);
        example.createCriteria().andEqualTo("companyId", companyId).andEqualTo("deleteType", 0);
        List<CompanyTalentStat> companyTalentStatList = companyTalentStatMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyTalentStatList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业人才统计信息
     * @date: 11:18 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyTalentStat(CompanyTalentReqParam companyTalentReqParam) {
        Example example = new Example(CompanyTalentStat.class);
        example.createCriteria().andEqualTo("companyId", companyTalentReqParam.getCompanyId());
        CompanyTalentStat companyTalentStat = new CompanyTalentStat();
        BeanUtils.copyProperties(companyTalentReqParam, companyTalentStat);
        companyTalentStat.setUpdateTime(new Date());
        int isOk = companyTalentStatMapper.updateByExampleSelective(companyTalentStat, example);
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
     * @description: 添加企业人才统计信息
     * @date: 11:24 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyTalentStat(CompanyTalentReqParam companyTalentReqParam) {
        CompanyTalentStat companyTalentStat = new CompanyTalentStat();
        BeanUtils.copyProperties(companyTalentReqParam, companyTalentStat);
        companyTalentStat.setDeleteType(0);
        companyTalentStat.setCreateTime(new Date());
        companyTalentStat.setUpdateTime(new Date());
        int isOk = companyTalentStatMapper.insertSelective(companyTalentStat);
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
     * @description: 获取企业团队(人才信息)
     * @date: 16:46 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyTalentInfoList(Long companyId) {
        Example companyTalentExample = new Example(CompanyTalent.class);
        companyTalentExample.createCriteria().andEqualTo("companyId", companyId).andNotEqualTo("deleteType", 1);
        List<CompanyTalent> companyTalentList = companyTalentMapper.selectByExample(companyTalentExample);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业人才(团队信息)
     * @date: 16:58 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyTalentInfo(CompanyTalentReqParam companyTalentReqParam) {
        Example example = new Example(CompanyTalent.class);
        example.createCriteria().andEqualTo("companyId", companyTalentReqParam.getCompanyId());
        CompanyTalent companyTalent = new CompanyTalent();
        BeanUtils.copyProperties(companyTalentReqParam, companyTalent);
        companyTalent.setUpdateTime(new Date());
        int isOk = companyTalentMapper.updateByExampleSelective(companyTalent, example);
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
     * @description: 新增企业人才信息
     * @date: 11:33 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyTalentInfo(CompanyTalentReqParam companyTalentReqParam) {
        CompanyTalent companyTalent = new CompanyTalent();
        BeanUtils.copyProperties(companyTalentReqParam, companyTalent);
        companyTalent.setDeleteType(0);
        companyTalent.setCreateTime(new Date());
        companyTalent.setUpdateTime(new Date());
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
     * @description: 根据搜索条件查询所有产品信息列表
     * @date: 10:05 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyProductInfo(CompanyProductReqParam companyProductReqParam) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        try {
            //组装查询条件
            CompanyProduct companyProduct = new CompanyProduct();
            Company company = new Company();
            if (MyStringUtils.isNotBlank(companyProductReqParam.getProductName())) {
                companyProduct.setProductName(companyProductReqParam.getProductName());
            }
            if (MyStringUtils.isNotBlank(companyProductReqParam.getIndustry())) {
                companyProduct.setIndustry(companyProductReqParam.getIndustry());
            }
            if (MyStringUtils.isNotBlank(companyProductReqParam.getCompanyName())) {
                companyProduct.setCompanyName(companyProductReqParam.getCompanyName());
            }
            if (MyStringUtils.isNotBlank(companyProductReqParam.getRoundNum())) {
                company.setRoundNum(companyProductReqParam.getRoundNum());
            }
            if (companyProductReqParam.getEntryStartDate() != null) {
                company.setEntryStartDate(companyProductReqParam.getEntryStartDate());
            }
            if (companyProductReqParam.getEntryEndDate() != null) {
                company.setEntryEndDate(companyProductReqParam.getEntryEndDate());
            }
            companyProduct.setCompany(company);
            //设置分页参数
            PageHelper.startPage(companyProductReqParam.getPageIndex(), companyProductReqParam.getPageSize());
            //查询结果
            List<CompanyProduct> companyProductList = companyProductMapper.getProductList(companyProduct);
            BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(companyProductList);
            commonListRespParam.setBasePageParam(basePageParam);
            List<ConCompanyProductInfoData> conCompanyProductInfoDataList = new ArrayList<ConCompanyProductInfoData>();
            if (MyCollectionsUtils.isNotEmpty(companyProductList)) {
                for (CompanyProduct product : companyProductList) {
                    ConCompanyProductInfoData conCompanyProductInfoData = new ConCompanyProductInfoData();
                    BeanUtils.copyProperties(product, conCompanyProductInfoData);
                    conCompanyProductInfoData.setRoundNum(product.getCompany().getRoundNum());
                    conCompanyProductInfoData.setEntryTime(product.getCompany().getEntryTime());
                    conCompanyProductInfoDataList.add(conCompanyProductInfoData);
                }
            }
            commonListRespParam.setDataInfos(conCompanyProductInfoDataList);
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            commonListRespParam.setResultMsg(e.getMessage());
        }
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 添加产品信息
     * @date: 15:10 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyProductInfo(CompanyProductReqParam companyProductReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            //将视图层接收数据转换为持久层数据
            CompanyProduct companyProduct = new CompanyProduct();
            BeanUtils.copyProperties(companyProductReqParam, companyProduct);
            if (MyStringUtils.isNotBlank(companyProductReqParam.getCompanyId().toString())) {
                //如果没有选择公司,则些项目是属于园区
                //登录模块暂时未开发,设置一个固定的园区ID(正常情况下是从登录信息中取园区信息)
                companyProduct.setParkId(Long.parseLong(environment.getProperty("park.parkId")));
            }
            companyProduct.setDeleteType(0);
            companyProduct.setCreateTime(new Date());
            companyProduct.setUpdateTime(new Date());
            companyProductMapper.insertSelective(companyProduct);
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            baseRespParam.setResultMsg(e.getMessage());
        }
        return baseRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改产品/项目信息
     * @date: 11:40 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyProductInfo(CompanyProductReqParam companyProductReqParam) {
        Example example = new Example(CompanyProduct.class);
        example.createCriteria().andEqualTo("companyId", companyProductReqParam.getCompanyId());
        CompanyProduct companyProduct = new CompanyProduct();
        BeanUtils.copyProperties(companyProductReqParam, companyProduct);
        companyProduct.setUpdateTime(new Date());
        int isOk = companyProductMapper.updateByExampleSelective(companyProduct, example);
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
     * @description: 获取企业知识产权相关信息
     * @date: 11:21 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyCopyrightInfo(Long companyId) {
        Example example = new Example(CompanyCopyright.class);
        example.createCriteria().andEqualTo("companyId", companyId).andEqualTo("deleteType", 0);
        List<CompanyCopyright> companyCopyrightList = companyCopyrightMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyCopyrightList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业专利信息
     * @date: 14:05 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyCopyrightInfo(CompanyCopyrightReqParam companyCopyrightReqParam) {
        CompanyCopyright companyCopyright = new CompanyCopyright();
        BeanUtils.copyProperties(companyCopyrightReqParam, companyCopyright);
        companyCopyright.setDeleteType(0);
        companyCopyright.setCreateTime(new Date());
        companyCopyright.setUpdateTime(new Date());
        int isOk = companyCopyrightMapper.insertSelective(companyCopyright);
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
     * @description: 修改企业专利信息
     * @date: 14:05 2018/6/29
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyCopyrightInfo(CompanyCopyrightReqParam companyCopyrightReqParam) {
        Example example = new Example(CompanyCopyright.class);
        example.createCriteria().andEqualTo("companyId", companyCopyrightReqParam.getCompanyId());
        CompanyCopyright companyCopyright = new CompanyCopyright();
        BeanUtils.copyProperties(companyCopyrightReqParam, companyCopyright);
        companyCopyright.setUpdateTime(new Date());
        int isOk = companyCopyrightMapper.updateByExampleSelective(companyCopyright, example);
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
     * @description: 查看企业需求信息
     * @date: 11:25 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyDemandsInfo(Long companyId) {
        Example example = new Example(CompanyDemands.class);
        example.createCriteria().andEqualTo("companyId", companyId).andEqualTo("deleteType", 0);
        example.orderBy("createTime").desc();
        List<CompanyDemands> companyDemandsList = companyDemandsMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyDemandsList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业需求信息
     * @date: 15:35 2018/7/8
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonRespParam addCompanyDemandsInfo(CompanyDemandsReqParam companyDemandsReqParam) {
        CommonRespParam commonRespParam = new CommonRespParam();
        try {
            CompanyDemands companyDemands = new CompanyDemands();
            BeanUtils.copyProperties(companyDemandsReqParam, companyDemands);
            companyDemands.setDeleteType(0);
            companyDemands.setCreateTime(companyDemandsReqParam.getCreateTime());
            companyDemands.setUpdateTime(companyDemandsReqParam.getCreateTime());
            int isOk = companyDemandsMapper.insertSelective(companyDemands);

            if (isOk > 0) {
                commonRespParam.setDataInfo(companyDemands);
            } else {
                commonRespParam.setResultCode(Message.SUCCESS_CODE);
                commonRespParam.setResultMsg(Message.SUCCESS);
            }

        } catch (Exception e) {
            logger.info(e.getMessage());
            commonRespParam.setResultCode(Message.FAILURE_CODE);
            commonRespParam.setResultMsg(e.getMessage());
        }
        return commonRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业需求信息
     * @date: 15:35 2018/7/8
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam deleteCompanyDemandsInfo(Long id) {
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            Example example = new Example(CompanyDemands.class);
            example.createCriteria().andEqualTo("id", id);
            CompanyDemands companyDemands = new CompanyDemands();
            companyDemands.setDeleteType(1);
            companyDemands.setUpdateTime(new Date());
            companyDemands.setDeleteTime(new Date());
            int isOk = companyDemandsMapper.updateByExampleSelective(companyDemands, example);
            if (isOk > 0) {
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(e.getMessage());
        }
        return baseRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业需求信息
     * @date: 15:35 2018/7/8
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyDemandsInfo(CompanyDemandsReqParam companyDemandsReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            Example example = new Example(CompanyDemands.class);
            example.createCriteria().andEqualTo("id", companyDemandsReqParam.getId());
            CompanyDemands companyDemands = new CompanyDemands();
            BeanUtils.copyProperties(companyDemandsReqParam, companyDemands);
            companyDemands.setUpdateTime(new Date());
            int isOk = companyDemandsMapper.updateByExampleSelective(companyDemands, example);
            if (isOk > 0) {
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(e.getMessage());
        }
        return baseRespParam;
    }


    /**
     * @author: CrazyZhou
     * @description: 获取企业工商注册信息
     * @date: 16:08 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getOneCompanyFinancingInfo(Long companyId) {
        Example companyFinancingExample = new Example(CompanyFinancing.class);
        companyFinancingExample.createCriteria().andEqualTo("companyId", companyId).andNotEqualTo("deleteType", 1);
        List<CompanyFinancing> companyFinancingList = companyFinancingMapper.selectByExample(companyFinancingExample);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyFinancingList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 获取企业股东信息
     * @date: 16:08 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getOneShareholderInformation(Long companyId) {
        Example shareholderInformationExample = new Example(ShareholderInformation.class);
        shareholderInformationExample.createCriteria().andEqualTo("companyId", companyId).andNotEqualTo("deleteType", 1);
        List<ShareholderInformation> shareholderInformationList = shareholderInformationMapper.selectByExample(shareholderInformationExample);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(shareholderInformationList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业股东信息
     * @date: 16:19 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateShareholderInformation(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        Example example = new Example(ShareholderInformation.class);
        ShareholderInformation shareholderInformation = new ShareholderInformation();
        BeanUtils.copyProperties(companyBasicInfoReqParam, shareholderInformation);
        if (MyStringUtils.isNotBlank(companyBasicInfoReqParam.getEmployeeName())) {
            shareholderInformation.setName(companyBasicInfoReqParam.getEmployeeName());
        }
        shareholderInformation.setUpdateTime(new Date());
        example.createCriteria().andEqualTo("id", companyBasicInfoReqParam.getId());
        int isOk = shareholderInformationMapper.updateByExampleSelective(shareholderInformation, example);
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
     * @description: 删除企业股东信息
     * @date: 16:29 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam deleteShareholderInfomation(Long id) {
        Example example = new Example(ShareholderInformation.class);
        example.createCriteria().andEqualTo("id", id);
        ShareholderInformation shareholderInformation = new ShareholderInformation();
        shareholderInformation.setDeleteType(1);
        shareholderInformation.setUpdateTime(new Date());
        shareholderInformation.setDeleteTime(new Date());
        int isOk = shareholderInformationMapper.updateByExampleSelective(shareholderInformation, example);
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
     * @description: 添加企业股东信息
     * @date: 17:28 2018/7/5
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonRespParam addShareholderInfomation(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        CommonRespParam commonRespParam = new CommonRespParam();
        try {
            ShareholderInformation shareholderInformation = new ShareholderInformation();
            BeanUtils.copyProperties(companyBasicInfoReqParam, shareholderInformation);
            shareholderInformation.setCreateTime(new Date());
            shareholderInformation.setUpdateTime(new Date());
            shareholderInformation.setDeleteType(0);
            int isOk = shareholderInformationMapper.insertSelective(shareholderInformation);
            commonRespParam.setDataInfo(shareholderInformation);
            if (isOk > 0) {
                return commonRespParam;
            } else {
                commonRespParam.setResultCode(Message.FAILURE_CODE);
                commonRespParam.setResultMsg(Message.FAILURE);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            commonRespParam.setResultMsg(e.getMessage());
        }
        return commonRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 获取企业员工信息
     * @date: 16:08 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getOneEmployeeInformation(Long companyId) {
        Example employeeInformationExample = new Example(EmployeeInformation.class);
        employeeInformationExample.createCriteria().andEqualTo("companyId", companyId).andNotEqualTo("deleteType", 1);
        List<EmployeeInformation> employeeInformationList = employeeInformationMapper.selectByExample(employeeInformationExample);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(employeeInformationList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业员工 信息
     * @date: 16:34 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateEmployeeInformation(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        Example example = new Example(EmployeeInformation.class);
        example.createCriteria().andEqualTo("id", companyBasicInfoReqParam.getId());
        EmployeeInformation employeeInformation = new EmployeeInformation();
        if (MyStringUtils.isNotBlank(companyBasicInfoReqParam.getEmployeeName())) {
            employeeInformation.setName(companyBasicInfoReqParam.getEmployeeName());
        }
        if (MyStringUtils.isNotBlank(companyBasicInfoReqParam.getPosition())) {
            employeeInformation.setPosition(companyBasicInfoReqParam.getPosition());
        }
        employeeInformation.setUpdateTime(new Date());
        int isOk = employeeInformationMapper.updateByExampleSelective(employeeInformation, example);
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
     * @description: 删除企业员工信息
     * @date: 16:40 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam deleteEmployeeInformation(Long id) {
        Example example = new Example(EmployeeInformation.class);
        example.createCriteria().andEqualTo("id", id);
        EmployeeInformation employeeInformation = new EmployeeInformation();
        employeeInformation.setDeleteType(1);
        employeeInformation.setUpdateTime(new Date());
        employeeInformation.setDeleteTime(new Date());
        int isOk = employeeInformationMapper.updateByExampleSelective(employeeInformation, example);
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
     * @description: 添加企业主要人员信息
     * @date: 17:35 2018/7/5
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonRespParam addEmployeeInformation(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        CommonRespParam commonRespParam = new CommonRespParam();
        try {
            EmployeeInformation employeeInformation = new EmployeeInformation();
            BeanUtils.copyProperties(companyBasicInfoReqParam, employeeInformation);
            employeeInformation.setName(companyBasicInfoReqParam.getEmployeeName());
            employeeInformation.setCreateTime(new Date());
            employeeInformation.setUpdateTime(new Date());
            employeeInformation.setDeleteType(0);
            int isOk = employeeInformationMapper.insertSelective(employeeInformation);
            if (isOk > 0) {
                commonRespParam.setDataInfo(employeeInformation);
                return commonRespParam;
            } else {
                commonRespParam.setResultCode(Message.FAILURE_CODE);
                commonRespParam.setResultMsg(Message.FAILURE);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            commonRespParam.setResultMsg(e.getMessage());
        }
        return commonRespParam;
    }


    /**
     * @author: CrazyZhou
     * @description: 获取企业产品相关导师信息
     * @date: 18:19 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getProductTeacherInfo(Long productId) {
        Example example = new Example(ProductTeacher.class);
        example.createCriteria().andEqualTo("productId", productId).andEqualTo("deleteType", 0);
        List<ProductTeacher> productTeacherList = productTeacherMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(productTeacherList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业产品相关导师信息
     * @date: 18:28 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateProductTeacherInfo(ProductTeacherReqParam productTeacherReqParam) {
        Example example = new Example(ProductTeacher.class);
        example.createCriteria().andEqualTo("productId", productTeacherReqParam.getProductId());
        ProductTeacher productTeacher = new ProductTeacher();
        BeanUtils.copyProperties(productTeacherReqParam, productTeacher);
        productTeacher.setUpdateTime(new Date());
        int isOk = productTeacherMapper.updateByExampleSelective(productTeacher, example);
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
     * @description: 查询企业相关专利信息
     * @date: 19:21 2018/6/26
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyPatentInfoList(Long companyId) {
        Example example = new Example(CompanyPatent.class);
        example.createCriteria().andEqualTo("companyId", companyId).andEqualTo("deleteType", 0);
        List<CompanyPatent> companyPatentList = companyPatentMapper.selectByExample(example);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setDataInfos(companyPatentList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 修改专利信息
     * @date: 9:02 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyPatentInfo(CompanyPatentReqParam companyPatentReqParam) {
        Example example = new Example(CompanyPatent.class);
        example.createCriteria().andEqualTo(companyPatentReqParam.getCompanyId());
        CompanyPatent companyPatent = new CompanyPatent();
        BeanUtils.copyProperties(companyPatentReqParam, companyPatent);
        companyPatent.setUpdateTime(new Date());
        int isOk = companyPatentMapper.updateByExampleSelective(companyPatent, example);
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
     * @description: 添加企业专利信息
     * @date: 9:45 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyPatentInfo(CompanyPatentReqParam companyPatentReqParam) {
        CompanyPatent companyPatent = new CompanyPatent();
        BeanUtils.copyProperties(companyPatentReqParam, companyPatent);
        companyPatent.setDeleteType(0);
        companyPatent.setCreateTime(new Date());
        companyPatent.setUpdateTime(new Date());
        int isOk = companyPatentMapper.insertSelective(companyPatent);
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
     * @description: 获取企业新闻列表
     * @date: 9:51 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyNewsInfoList(CompanyNewsReqParam companyNewsReqParam) {
        //组装查询条件
        Example example = new Example(CompanyNews.class);
        example.createCriteria().andEqualTo("companyId", companyNewsReqParam.getCompanyId()).andEqualTo("deleteType", 0);
        //设置分页参数
        PageHelper.startPage(companyNewsReqParam.getPageIndex(), companyNewsReqParam.getPageSize());
        List<CompanyNews> companyNewsList = companyNewsMapper.selectByExample(example);
        BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(companyNewsList);
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        commonListRespParam.setBasePageParam(basePageParam);
        List<CompanyNewsResParam> companyNewsResParamList = new ArrayList<CompanyNewsResParam>();
        //将查询结果转换为视图层对象
        for (CompanyNews companyNews : companyNewsList) {
            CompanyNewsResParam companyNewsResParam = new CompanyNewsResParam();
            BeanUtils.copyProperties(companyNews, companyNewsResParam);
            companyNewsResParamList.add(companyNewsResParam);
        }
        commonListRespParam.setDataInfos(companyNewsResParamList);
        return commonListRespParam;
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业基本信息
     * @date: 14:03 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam addCompanyBasicInfo(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        //保存企业基本信息
        BaseRespParam baseRespParam = new BaseRespParam();
        Company company = new Company();
        BeanUtils.copyProperties(companyBasicInfoReqParam, company);
        company.setDeleteType(0);
        company.setCreateTime(new Date());
        company.setUpdateTime(new Date());
        company.setParkId(Long.parseLong(environment.getProperty("park.parkId")));
        int isOk = companyMapper.insertSelective(company);
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
     * @description: 判断公司名称是否重复
     * @date: 14:31 2018/7/5
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam judgeCompanyNameWhetherRepeat(String companyName, Long id) {
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            Example companyExample = new Example(Company.class);
            Example.Criteria criteria = companyExample.createCriteria();
            companyExample.selectProperties("id");
            criteria.andEqualTo("companyName", companyName);
            if (id != null) {
                criteria.andNotEqualTo("id", id);
            }
            List<Company> companyList = companyMapper.selectByExample(companyExample);
            if (MyCollectionsUtils.isNotEmpty(companyList)) {
                baseRespParam.setResultCode(Message.COMPANY_IS_EXIST_CODE);
                baseRespParam.setResultMsg(Message.COMPANY_IS_EXIST);
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.COMPANY_IS_NOT_EXIST_CODE);
                baseRespParam.setResultMsg(Message.COMPANY_IS_NOT_EXIST);
                return baseRespParam;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            baseRespParam.setResultMsg(e.getMessage());
            return baseRespParam;
        }
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业信息列表
     * @date: 14:56 2018/6/28
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyInfoList(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        try {
            //拼接查询条件
            Example example = spliceInquireCondition(companyBasicInfoReqParam);
            //设置分页参数
            PageHelper.startPage(companyBasicInfoReqParam.getPageIndex(), companyBasicInfoReqParam.getPageSize());
            example.excludeProperties("entryStartDate", "entryEndDate");
            example.orderBy("entryTime").desc();
            List<Company> companyList = companyMapper.selectByExample(example);
            BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(companyList);
            commonListRespParam.setBasePageParam(basePageParam);
            commonListRespParam.setDataInfos(companyList);
            return commonListRespParam;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            commonListRespParam.setResultMsg(e.getMessage());
            return commonListRespParam;
        }
    }

    /**
     * @author: CrazyZhou
     * @description: 拼接企业信息查询条件
     * @date: 15:43 2018/6/28
     * @param: * @param null
     * @return:
     */
    public Example spliceInquireCondition(CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        Example example = new Example(Company.class);
        Example.Criteria criteria = example.createCriteria();
        if (MyStringUtils.isNotBlank(companyBasicInfoReqParam.getCompanyName())) {
            criteria.andLike("companyName", "%" + companyBasicInfoReqParam.getCompanyName() + "%");
        }
        if (MyStringUtils.isNotBlank(companyBasicInfoReqParam.getBusinese())) {
            criteria.andLike("businese", "%" + companyBasicInfoReqParam.getBusinese() + "%");
        }
        if (companyBasicInfoReqParam.getRegisterMinCapital() != null) {
            criteria.andGreaterThanOrEqualTo("registeredCapital", companyBasicInfoReqParam.getRegisterMinCapital());
        }
        if (companyBasicInfoReqParam.getRegisterMaxCapital() != null) {
            criteria.andLessThanOrEqualTo("registeredCapital", companyBasicInfoReqParam.getRegisterMaxCapital());
        }
        if (companyBasicInfoReqParam.getEntryState() != null) {
            criteria.andEqualTo("entryState", companyBasicInfoReqParam.getEntryState());
        }
        if (companyBasicInfoReqParam.getRegisterStartTime() != null) {
            criteria.andGreaterThanOrEqualTo("establishmentDate", companyBasicInfoReqParam.getRegisterStartTime());
        }
        if (companyBasicInfoReqParam.getRegisterEndTime() != null) {
            criteria.andLessThanOrEqualTo("establishmentDate", companyBasicInfoReqParam.getRegisterEndTime());
        }
        if (companyBasicInfoReqParam.getEntryStartTime() != null) {
            criteria.andGreaterThanOrEqualTo("entryTime", companyBasicInfoReqParam.getEntryStartTime());
        }
        if (companyBasicInfoReqParam.getEntryEndTime() != null) {
            criteria.andLessThanOrEqualTo("entryTime", companyBasicInfoReqParam.getEntryEndTime());
        }
        example.orderBy("entryTime").desc();
        //设置园区Id
        criteria.andEqualTo("parkId", environment.getProperty("park.parkId"));
        return example;
    }

    /**
     * @author: CrazyZhou
     * @description: 导出企业信息列表
     * @date: 15:42 2018/6/28
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam exportCompanyInfoList(HttpServletResponse response, CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        Example example = spliceInquireCondition(companyBasicInfoReqParam);
        example.selectProperties("id", "companyName", "category", "registeredCapital", "approvalDate",
                "entryTime", "businese", "entryState", "contact", "contactNumber", "commentMessage");
        List<Company> companyList = companyMapper.selectByExample(example);
        String excelName = "企业基本信息表";
        // 获取需要转出的excle表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        fieldMap.put("companyName", "企业名称");
        fieldMap.put("category", "企业类别");
        fieldMap.put("registeredCapital", "注册资金");
        fieldMap.put("approvalDate", "注册时间");
        fieldMap.put("entryTime", "入孵/入园时间");
        fieldMap.put("businese", "主营业务");
        fieldMap.put("entryState", "目前状态");
        fieldMap.put("contact", "联系人");
        fieldMap.put("contactNumber", "联系方式");
        fieldMap.put("commentMessage", "备注");
        BaseRespParam baseRespParam = new BaseRespParam();
        try {
            NewExportToExcelUtil.export(excelName, companyList, fieldMap, response);
            return baseRespParam;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            baseRespParam.setResultMsg(e.getMessage());
            return baseRespParam;
        }
    }

    public static <E> List<Object> toObject(List<E> list) {
        List<Object> objlist = new ArrayList<Object>();
        for (Object e : list) {
            Object obj = (Object) e;
            objlist.add(obj);
        }
        return objlist;
    }
}
