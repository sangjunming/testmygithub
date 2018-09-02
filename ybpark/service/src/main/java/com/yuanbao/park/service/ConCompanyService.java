package com.yuanbao.park.service;

import com.yuanbao.park.common.req.*;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author: CrazyZhou
 * @description: 产品相关信息接口层
 * @date: 2018-06-25 19:45
 * @param:
 */
public interface ConCompanyService {

    /**
     * @author: CrazyZhou
     * @description: 获取企业基本信息
     * @date: 16:03 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getOneCompanyInfo(Long companyId,Long parkId);

    /**
     * @author: CrazyZhou
     * @description: 修改企业基本信息
     * @date: 10:28 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateOneCompanyInfo(CompanyBasicInfoReqParam companyBasicInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 获取企业资料信息
     * @date: 11:02 2018/6/27
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyArchiveInfo(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 删除企业资料信息
     * @date: 10:45 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam deleteCompanyArchiveInfo(Long id);

    /**
     * @author: CrazyZhou
     * @description: 新增企业资料信息
     * @date: 10:40 2018/7/8
     * @param:  * @param null
     * @return:
     */
    BaseRespParam addCompanyArchiveInfo(CompanyArchiveInfoReqParam companyArchiveInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 获取企业经营信息
     * @date: 11:07 2018/6/27
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyOperateInfo(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 新增企业经营信息
     * @date: 10:54 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam addCompanyOperateInfo(CompanyOperateInfoReqParam companyOperateInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 修改企业经营信息
     * @date: 11:01 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateCompanyOperateInfo(CompanyOperateInfoReqParam companyOperateInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 获取企业融资信息
     * @date: 18:42 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyFinancingInfo(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 新增企业融资信息
     * @date: 18:52 2018/6/26
     * @param: * @param null
     * @return:
     */
    BaseRespParam addCompanyFinancingInfo(CompanyFinancingReqParam companyFinancingReqParam);

    /**
     * @author: CrazyZhou
     * @description: 删除企业融资信息
     * @date: 19:01 2018/6/26
     * @param: * @param null
     * @return:
     */
    BaseRespParam delCompanyFinancingInfo(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 获取企业人才统计信息
     * @date: 11:10 2018/6/27
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyTalentStat(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 修改企业人才统计信息
     * @date: 11:17 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateCompanyTalentStat(CompanyTalentReqParam companyTalentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 添加企业人才统计信息
     * @date: 11:23 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam addCompanyTalentStat(CompanyTalentReqParam companyTalentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 查询企业团队信息(企业人才信息)
     * @date: 16:40 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyTalentInfoList(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 修改企业人才信息
     * @date: 16:58 2018/6/26
     * @param: * @param null
     * @return:
     */
    BaseRespParam updateCompanyTalentInfo(CompanyTalentReqParam companyTalentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 新增企业人才信息
     * @date: 11:32 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam addCompanyTalentInfo(CompanyTalentReqParam companyTalentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 获取所有产品信息
     * @date: 10:04 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyProductInfo(CompanyProductReqParam companyProductReqParam);

    /**
     * @author: CrazyZhou
     * @description: 添加产品信息
     * @date: 15:07 2018/6/26
     * @param: * @param null
     * @return:
     */
    BaseRespParam addCompanyProductInfo(CompanyProductReqParam companyProductReqParam);

    /**
     * @author: CrazyZhou
     * @description: 修改产品/项目信息
     * @date: 11:40 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateCompanyProductInfo(CompanyProductReqParam companyProductReqParam);

    /**
     * @author: CrazyZhou
     * @description: 获取企业知识产权信息
     * @date: 11:20 2018/6/27
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyCopyrightInfo(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 查看企业需求信息
     * @date: 11:24 2018/6/27
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyDemandsInfo(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 添加企业需求信息
     * @date: 15:34 2018/7/8
     * @param:  * @param null
     * @return:
     */
    CommonRespParam addCompanyDemandsInfo(CompanyDemandsReqParam companyDemandsReqParam);

    /**
     * @author: CrazyZhou
     * @description: 删除企业需求信息
     * @date: 15:34 2018/7/8
     * @param:  * @param null
     * @return:
     */
    BaseRespParam deleteCompanyDemandsInfo(Long id);

    /**
     * @author: CrazyZhou
     * @description: 修改企业需求信息
     * @date: 15:35 2018/7/8
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateCompanyDemandsInfo(CompanyDemandsReqParam companyDemandsReqParam);

    /**
     * @author: CrazyZhou
     * @description: 查询企业工商注册信息
     * @date: 16:07 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getOneCompanyFinancingInfo(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 查询企业股东相关信息
     * @date: 16:07 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getOneShareholderInformation(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 修改企业股东相关信息
     * @date: 16:19 2018/6/27
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateShareholderInformation(CompanyBasicInfoReqParam companyBasicInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 修改企业股东相关信息
     * @date: 16:29 2018/6/27
     * @param:  * @param null
     * @return:
     */
    BaseRespParam deleteShareholderInfomation(Long id);

    /**
     * @author: CrazyZhou
     * @description: 添加企业股东信息
     * @date: 17:28 2018/7/5
     * @param:  * @param null
     * @return:
     */
    CommonRespParam addShareholderInfomation(CompanyBasicInfoReqParam companyBasicInfoReqParam);


    /**
     * @author: CrazyZhou
     * @description: 查询企业主要人员相关信息
     * @date: 16:08 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getOneEmployeeInformation(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 修改企业主要员工信息
     * @date: 16:33 2018/6/27
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateEmployeeInformation(CompanyBasicInfoReqParam companyBasicInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 删除企业主要人员信息
     * @date: 16:40 2018/6/27
     * @param:  * @param null
     * @return:
     */
    BaseRespParam deleteEmployeeInformation(Long id);

    /**
     * @author: CrazyZhou
     * @description: 添加企业主要人员信息
     * @date: 17:34 2018/7/5
     * @param:  * @param null
     * @return:
     */
    CommonRespParam addEmployeeInformation(CompanyBasicInfoReqParam companyBasicInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 查询产品导师信息
     * @date: 18:18 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getProductTeacherInfo(Long productId);

    /**
     * @author: CrazyZhou
     * @description: 修改企业产品相关导师 信息
     * @date: 18:27 2018/6/26
     * @param: * @param null
     * @return:
     */
    BaseRespParam updateProductTeacherInfo(ProductTeacherReqParam productTeacherReqParam);



    /**
     * @author: CrazyZhou
     * @description: 获取企业专利信息列表
     * @date: 19:21 2018/6/26
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyPatentInfoList(Long companyId);

    /**
     * @author: CrazyZhou
     * @description: 修改企业专利信息
     * @date: 9:20 2018/6/27
     * @param: * @param null
     * @return:
     */
    BaseRespParam updateCompanyPatentInfo(CompanyPatentReqParam companyPatentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 添加企业专利信息
     * @date: 9:45 2018/6/27
     * @param: * @param null
     * @return:
     */
    BaseRespParam addCompanyPatentInfo(CompanyPatentReqParam companyPatentReqParam);

    /**
     * @author: CrazyZhou
     * @description: 获取企业新闻列表
     * @date: 9:51 2018/6/27
     * @param: * @param null
     * @return:
     */
    CommonListRespParam getCompanyNewsInfoList(CompanyNewsReqParam companyNewsReqParam);

    /**
     * @author: CrazyZhou
     * @description: 添加公司基本信息
     * @date: 13:58 2018/6/27
     * @param: * @param null
     * @return:
     */
    BaseRespParam addCompanyBasicInfo( CompanyBasicInfoReqParam companyBasicInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 添加公司基本信息时判断公司名称是否重名
     * @date: 14:30 2018/7/5
     * @param:  * @param null
     * @return:
     */
    BaseRespParam judgeCompanyNameWhetherRepeat(String companyName,Long id);

    /**
     * @author: CrazyZhou
     * @description: 查询企业信息列表
     * @date: 14:56 2018/6/28
     * @param:  * @param null
     * @return:
     */
    CommonListRespParam getCompanyInfoList(CompanyBasicInfoReqParam companyBasicInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 导出企业信息列表
     * @date: 15:41 2018/6/28
     * @param:  * @param null
     * @return:
     */
    BaseRespParam exportCompanyInfoList(HttpServletResponse response, CompanyBasicInfoReqParam companyBasicInfoReqParam);

    /**
     * @author: CrazyZhou
     * @description: 添加企业专利信息(知识产权信息)
     * @date: 14:03 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam addCompanyCopyrightInfo(CompanyCopyrightReqParam companyCopyrightReqParam);

    /**
     * @author: CrazyZhou
     * @description: 修改企业专利信息(知识产权信息)
     * @date: 14:04 2018/6/29
     * @param:  * @param null
     * @return:
     */
    BaseRespParam updateCompanyCopyrightInfo(CompanyCopyrightReqParam companyCopyrightReqParam);


}
