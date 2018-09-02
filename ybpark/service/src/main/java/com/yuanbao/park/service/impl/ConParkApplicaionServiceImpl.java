package com.yuanbao.park.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.ParkApplicationReqParam;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.respPojo.ParkApplicationInfoData;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.BasePageRespParamsUtils;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.controller.ConParkApplicaionController;
import com.yuanbao.park.dao.master.ParkApplicationMapper;
import com.yuanbao.park.entity.ParkApplication;
import com.yuanbao.park.service.ConParkApplicaionService;

import tk.mybatis.mapper.entity.Example;
/**
 * @author: XianKang
 * @description: 园区入驻信息持久化层
 * @date: 10:58 2018/6/26
 * @param:  * @param null
 * @return:
 */
@Service
public class ConParkApplicaionServiceImpl implements ConParkApplicaionService{
	private static Logger logger = LoggerFactory.getLogger(ConParkApplicaionServiceImpl.class);
	@Autowired
	private ParkApplicationMapper parkApplicationMapper;
	/**
	 * @author: XianKang
	 * @description: 园区入驻信息查询
	 * @date: 10:58 2018/6/26
	 * @param:  * @param null
	 * @return:
	 */
	@Override
	public CommonListRespParam getParkApplicationInfo(ParkApplicationReqParam parkApplicationReqParam) {
			CommonListRespParam commonListRespParam = new CommonListRespParam();
			// TODO Auto-generated method stub
	        try {
				//拼接查询条件
				Example parkApplicationExample = new Example(ParkApplication.class);
				Example.Criteria parkApplicationExampleCriteria = parkApplicationExample.createCriteria();
				parkApplicationExampleCriteria.andEqualTo("parkId",parkApplicationReqParam.getParkId());
				parkApplicationExampleCriteria.andEqualTo("deleteType",0);
				//申请企业拼接
				if(MyStringUtils.isNotBlank(parkApplicationReqParam.getCompanyName())){
					parkApplicationExampleCriteria.andLike("applicationCompanyName","%"+parkApplicationReqParam.getCompanyName()+"%");
				}
				//申请日期拼接
				if(parkApplicationReqParam.getStartDate() != null ){
					parkApplicationExampleCriteria.andGreaterThanOrEqualTo("applicationDate",parkApplicationReqParam.getStartDate());
				}
				if( parkApplicationReqParam.getEndDate() != null){
					parkApplicationExampleCriteria.andLessThanOrEqualTo("applicationDate",parkApplicationReqParam.getEndDate());
				}
				//企业联系人拼接
				if(MyStringUtils.isNotBlank(parkApplicationReqParam.getCompanyContacts())){
					parkApplicationExampleCriteria.andLike("name","%"+parkApplicationReqParam.getCompanyContacts()+"%");
				}
				//联系电话拼接
				if(MyStringUtils.isNotBlank(parkApplicationReqParam.getTelephone())){
					parkApplicationExampleCriteria.andLike("telephone","%"+parkApplicationReqParam.getTelephone()+"%");
				}
				//申请状态
				if((parkApplicationReqParam.getApplicationType()!=null)){
					parkApplicationExampleCriteria.andEqualTo("applicationType",parkApplicationReqParam.getApplicationType());
				}
				parkApplicationExample.orderBy("applicationDate").desc();
				//设置分页参数
				PageHelper.startPage(parkApplicationReqParam.getPageIndex(),parkApplicationReqParam.getPageSize());
				List<ParkApplication> parkApplicationList = parkApplicationMapper.selectByExample(parkApplicationExample);
				//根据查询结果返回分页信息
				BasePageParam basePageParam = BasePageRespParamsUtils.buildBasePageParam(parkApplicationList);
                commonListRespParam.setBasePageParam(basePageParam);
                List<ParkApplicationInfoData> parkApplicationInfoDataList = new ArrayList<ParkApplicationInfoData>();
				if(MyCollectionsUtils.isNotEmpty(parkApplicationList)){
				    for (ParkApplication parkApplication : parkApplicationList) {
				    	ParkApplicationInfoData parkApplicationInfoData = new ParkApplicationInfoData();
				        BeanUtils.copyProperties(parkApplication,parkApplicationInfoData);
				        parkApplicationInfoDataList.add(parkApplicationInfoData);
				    }
				}
				commonListRespParam.setDataInfos(parkApplicationInfoDataList);
				return commonListRespParam;
			} catch (BeansException e) {
				logger.info(e.getMessage(), e);
				commonListRespParam.setResultCode(Message.FAILURE_CODE);
				commonListRespParam.setResultMsg(Message.FAILURE);
	            return commonListRespParam;
			}
		
	}
	

	
}
