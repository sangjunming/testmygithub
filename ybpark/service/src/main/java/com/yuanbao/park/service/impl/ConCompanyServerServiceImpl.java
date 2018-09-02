package com.yuanbao.park.service.impl;

import java.util.Date;
import java.util.List;

import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.yuanbao.park.common.req.CompanyServerReqParam;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.dao.master.CompanyServerMapper;
import com.yuanbao.park.entity.CompanyFinancing;
import com.yuanbao.park.entity.CompanyServer;
import com.yuanbao.park.service.ConCompanyServerService;
import tk.mybatis.mapper.entity.Example;

/**
 * @author: XianKang
 * @description: 企业服务持久化层
 * @date: 10:58 2018/6/27
 * @param: * @param null
 * @return:
 */
@Service
public class ConCompanyServerServiceImpl implements ConCompanyServerService {
    private static Logger logger = LoggerFactory.getLogger(ConCompanyServerServiceImpl.class);
    @Autowired
    private CompanyServerMapper companyServerMapper;
    @Autowired
    private Environment environment;

    /**
     * @author: XianKang
     * @description: 企业服务查询
     * @date: 10:58 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public CommonListRespParam getCompanyServerInfoData(CompanyServerReqParam companyServerReqParam) {
        CommonListRespParam commonListRespParam = new CommonListRespParam();
        // 拼接查询条件
        try {
            Example companyServerExample = new Example(CompanyServer.class);
            Example.Criteria companyServerExampleCriteria = companyServerExample.createCriteria();
            companyServerExampleCriteria.andEqualTo("parkId", companyServerReqParam.getParkId());
            companyServerExampleCriteria.andEqualTo("deleteType", 0);
            if (MyStringUtils.isNotBlank(companyServerReqParam.getKeyword())) {
                companyServerExampleCriteria.andLike("name", "%" + companyServerReqParam.getName() + "%");
                companyServerExampleCriteria.andLike("serviceTitle", "%" + companyServerReqParam.getServiceTitle() + "%");
            }
            List<CompanyServer> companyServerList = companyServerMapper.selectByExample(companyServerExample);
            commonListRespParam.setDataInfos(companyServerList);
            return commonListRespParam;
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            commonListRespParam.setResultCode(Message.FAILURE_CODE);
            commonListRespParam.setResultMsg(Message.FAILURE);
            return commonListRespParam;
        }
    }

    /**
     * @author: XianKang
     * @description: 企业服务添加
     * @date: 10:58 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam insertCompanyServerInfoData(CompanyServerReqParam companyServerReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        //此处尚未写登录功能，园区id写死
        Long parkId = Long.parseLong(environment.getProperty("park.parkId"));
        // 将视图层接收数据转换为持久层数据
        CompanyServer companyServer = new CompanyServer();
        companyServer.setParkId(parkId);
        companyServer.setPhoto(companyServerReqParam.getPhoto());
        companyServer.setServiceTitle(companyServerReqParam.getServiceTitle());
        companyServer.setName(companyServerReqParam.getName());
        companyServer.setContent(companyServerReqParam.getContent());
        companyServer.setSuccessedCase(companyServerReqParam.getSuccessedCase());
        companyServer.setDeleteType(0);
        companyServer.setCreateTime(new Date());
        companyServer.setUpdateTime(new Date());
        int isOk = companyServerMapper.insertSelective(companyServer);
        if (isOk > 0) {
            return baseRespParam;
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;
        }
    }

    /**
     * @author: XianKang
     * @description: 企业服务更新
     * @date: 10:58 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam updateCompanyServerInfoData(CompanyServerReqParam companyServerReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        Example example = new Example(CompanyServer.class);
        example.createCriteria().andEqualTo("id", companyServerReqParam.getId());
        CompanyServer companyServer = new CompanyServer();
        companyServer.setPhoto(companyServerReqParam.getPhoto());
        companyServer.setServiceTitle(companyServerReqParam.getServiceTitle());
        companyServer.setName(companyServerReqParam.getContent());
        companyServer.setContent(companyServerReqParam.getContent());
        companyServer.setSuccessedCase(companyServerReqParam.getSuccessedCase());
        companyServer.setUpdateTime(new Date());
        int isOk = companyServerMapper.updateByExampleSelective(companyServer, example);
        if (isOk > 0) {
            return baseRespParam;
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;
        }
    }

    /**
     * @author: XianKang
     * @description: 企业服务删除
     * @date: 10:58 2018/6/27
     * @param: * @param null
     * @return:
     */
    @Override
    public BaseRespParam deleteCompanyServerInfoData(Long id) {
        BaseRespParam baseRespParam = new BaseRespParam();
        Example example = new Example(CompanyFinancing.class);
        example.createCriteria().andEqualTo("id", id);
        CompanyServer companyServer = new CompanyServer();
        companyServer.setDeleteTime(new Date());
        companyServer.setDeleteType(1);
        int isOk = companyServerMapper.updateByExampleSelective(companyServer, example);
        if (isOk > 0) {
            return baseRespParam;
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
            return baseRespParam;
        }
    }


}
