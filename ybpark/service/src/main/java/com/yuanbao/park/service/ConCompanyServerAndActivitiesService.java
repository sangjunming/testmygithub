package com.yuanbao.park.service;

import com.yuanbao.park.common.req.CompanyServiceAndActivitiesReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;

public interface ConCompanyServerAndActivitiesService {

	CommonListRespParam getCompanyServerAndActivitiesInfoData(CompanyServiceAndActivitiesReqParam companyServiceAndActivitiesReqParam);

	BaseRespParam updataCompanyServerAndActivitiesInfoData(
			CompanyServiceAndActivitiesReqParam companyServerAndActivitiesReqParam);

	BaseRespParam deleteCompanyServerAndActivitiesInfoData(Long id);

	BaseRespParam insertCompanyServerAndActivitiesInfoData(
			CompanyServiceAndActivitiesReqParam companyServerAndActivitiesReqParam);

}
