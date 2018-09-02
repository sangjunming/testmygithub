package com.yuanbao.park.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.CompanyServiceAndActivitiesReqParam;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.respPojo.CompanyServiceAndActivityInfoData;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.BasePageRespParamsUtils;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.controller.ConCompanyServerAndActivitiesController;
import com.yuanbao.park.dao.master.CompanyServerMapper;
import com.yuanbao.park.dao.master.ServiceActivityMapper;
import com.yuanbao.park.entity.CompanyFinancing;
import com.yuanbao.park.entity.CompanyServer;
import com.yuanbao.park.entity.CompanyTalent;
import com.yuanbao.park.entity.ServiceActivity;
import com.yuanbao.park.service.ConCompanyServerAndActivitiesService;

import tk.mybatis.mapper.entity.Example;
/**
 * @author: XianKang
 * @description: 服务与活动相关信息持久层
 * @date: 10:58 2018/6/27
 * @param:  * @param null 
 * @return: 
 */
@Service
public class ConCompanyServerAndActivitiesServiceImpl implements ConCompanyServerAndActivitiesService {
	private static Logger logger = LoggerFactory.getLogger(ConCompanyServerAndActivitiesController.class);
	@Autowired
	private ServiceActivityMapper serviceActivityMapper;
	@Autowired
    private Environment environment;
	/**
	 * @author: XianKang
	 * @description: 服务与活动的分页查找
	 * @date: 10:58 2018/6/27
	 * @param:  * @param null 
	 * @return: 
	 */
	@Override
	public CommonListRespParam getCompanyServerAndActivitiesInfoData(CompanyServiceAndActivitiesReqParam companyServiceAndActivitiesReqParam) {
             CommonListRespParam commonListRespParam = new CommonListRespParam();
	         try {
				Example companyServerAndActivitiesExample = new Example(CompanyServer.class);
				Example.Criteria companyServerAndActivitiesExampleCriteria = companyServerAndActivitiesExample.createCriteria();
				companyServerAndActivitiesExampleCriteria.andEqualTo("parkId", companyServiceAndActivitiesReqParam.getParkId()).andEqualTo("deleteType", 0);
				if (MyStringUtils.isNotBlank(companyServiceAndActivitiesReqParam.getServiceName())) {
					companyServerAndActivitiesExampleCriteria.andLike("serviceName", "%"+companyServiceAndActivitiesReqParam.getServiceName()+"%");
				}
				
				if(MyStringUtils.isNotBlank(companyServiceAndActivitiesReqParam.getServerType())){
					companyServerAndActivitiesExampleCriteria.andEqualTo("serviceType",companyServiceAndActivitiesReqParam.getServerType());
				}
				
				if(companyServiceAndActivitiesReqParam.getStartDate() != null){
					companyServerAndActivitiesExampleCriteria.andGreaterThanOrEqualTo("serverTime",companyServiceAndActivitiesReqParam.getStartDate());
				}
				if (companyServiceAndActivitiesReqParam.getEndDate() != null){
					companyServerAndActivitiesExampleCriteria.andLessThanOrEqualTo("serverTime",companyServiceAndActivitiesReqParam.getEndDate());
				}
				
				if(MyStringUtils.isNotBlank(companyServiceAndActivitiesReqParam.getCompanyName())){
					companyServerAndActivitiesExampleCriteria.andLike("companyName","%"+companyServiceAndActivitiesReqParam.getCompanyName()+"%");
				}
				companyServerAndActivitiesExample.orderBy("serverTime").desc();
				PageHelper.startPage(companyServiceAndActivitiesReqParam.getStartIndex(),companyServiceAndActivitiesReqParam.getPageSize());
				List<ServiceActivity> serviceActivityList = serviceActivityMapper.selectByExample(companyServerAndActivitiesExample);
				BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(serviceActivityList);
                commonListRespParam.setBasePageParam(basePageParam);
                List<CompanyServiceAndActivityInfoData>  companyServerInfoDataList= new ArrayList<CompanyServiceAndActivityInfoData>();
				if(MyCollectionsUtils.isNotEmpty(serviceActivityList)){
				    for (ServiceActivity serviceActivity : serviceActivityList) {
				    	CompanyServiceAndActivityInfoData companyServerAndActivityInfoData = new CompanyServiceAndActivityInfoData();
				        BeanUtils.copyProperties(serviceActivity,companyServerAndActivityInfoData);
				        companyServerInfoDataList.add(companyServerAndActivityInfoData);
				    }
				}
				commonListRespParam.setDataInfos(companyServerInfoDataList);
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
	 * @description: 服务与活动的更新
	 * @date: 10:58 2018/6/27
	 * @param:  * @param null 
	 * @return: 
	 */
	@Override
	public BaseRespParam updataCompanyServerAndActivitiesInfoData(
			CompanyServiceAndActivitiesReqParam companyServerAndActivitiesReqParam) {
        BaseRespParam baseRespParam=new BaseRespParam();
		Example example = new Example(ServiceActivity.class);
        example.createCriteria().andEqualTo("id", companyServerAndActivitiesReqParam.getId());
        ServiceActivity serviceActivity=new ServiceActivity();
        serviceActivity.setServiceName(companyServerAndActivitiesReqParam.getServiceName());
        serviceActivity.setServiceType(companyServerAndActivitiesReqParam.getServerType());
        serviceActivity.setClient(companyServerAndActivitiesReqParam.getClient());
        serviceActivity.setCompanyName(companyServerAndActivitiesReqParam.getCompanyName());
        serviceActivity.setServerTime(companyServerAndActivitiesReqParam.getServerTime());
        serviceActivity.setLocation(companyServerAndActivitiesReqParam.getLocation());
        serviceActivity.setServiceActivityIntroduction(companyServerAndActivitiesReqParam.getServiceActivityIntroduction());
        serviceActivity.setAnnex(companyServerAndActivitiesReqParam.getAnnex());
        serviceActivity.setUpdateTime(new Date());
        int isOk = serviceActivityMapper.updateByExampleSelective(serviceActivity, example);
        if (isOk > 0) {
            return  baseRespParam;
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
            return  baseRespParam;
        }
		
	}
	
	/**
	 * @author: XianKang
	 * @description: 服务与活动相关信息刪除
	 * @date: 10:58 2018/6/27
	 * @param:  * @param null 
	 * @return: 
	 */
	@Override
	public BaseRespParam deleteCompanyServerAndActivitiesInfoData(Long id) {
        BaseRespParam baseRespParam=new BaseRespParam();
		Example example = new Example(ServiceActivity.class);
        example.createCriteria().andEqualTo("id",id);
        ServiceActivity serviceActivity = new ServiceActivity();
        serviceActivity.setDeleteType(1);
        serviceActivity.setDeleteTime(new Date());
        int isOk = serviceActivityMapper.updateByExampleSelective(serviceActivity, example);
        if (isOk > 0) {
            return  baseRespParam;
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
            return  baseRespParam;
        }
	}
	
	/**
	 * @author: XianKang
	 * @description: 服务与活动相关信息添加
	 * @date: 10:58 2018/6/27
	 * @param:  * @param null 
	 * @return: 
	 */
	@Override
	public BaseRespParam insertCompanyServerAndActivitiesInfoData(
			CompanyServiceAndActivitiesReqParam companyServerAndActivitiesReqParam) {
        BaseRespParam baseRespParam=new BaseRespParam();
		ServiceActivity serviceActivity=new ServiceActivity();
		serviceActivity.setParkId(Long.parseLong(environment.getProperty("park.parkId")));
	    serviceActivity.setServiceName(companyServerAndActivitiesReqParam.getServiceName());
	    serviceActivity.setServiceType(companyServerAndActivitiesReqParam.getServerType());
	    serviceActivity.setClient(companyServerAndActivitiesReqParam.getClient());
	    serviceActivity.setCompanyName(companyServerAndActivitiesReqParam.getCompanyName());
	    serviceActivity.setServerTime(companyServerAndActivitiesReqParam.getServerTime());
	    serviceActivity.setLocation(companyServerAndActivitiesReqParam.getLocation());
	    serviceActivity.setServiceActivityIntroduction(companyServerAndActivitiesReqParam.getServiceActivityIntroduction());
	    serviceActivity.setAnnex(companyServerAndActivitiesReqParam.getAnnex());
	    serviceActivity.setDeleteType(0);
	    serviceActivity.setCreateTime(new Date());
	    serviceActivity.setUpdateTime(new Date());
	    int isOk = serviceActivityMapper.insertSelective(serviceActivity);
        if (isOk > 0) {
            return  baseRespParam;
        } else {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE);
            return  baseRespParam;
        }
	}
	

}
