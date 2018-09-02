package com.yuanbao.park.service;

import com.yuanbao.park.common.req.CompanyServerReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;

public interface ConCompanyServerService {

	CommonListRespParam getCompanyServerInfoData(CompanyServerReqParam companyServerReqParam);

	BaseRespParam insertCompanyServerInfoData(CompanyServerReqParam companyServerReqParam);

	BaseRespParam updateCompanyServerInfoData(CompanyServerReqParam companyServerReqParam);

	BaseRespParam deleteCompanyServerInfoData(Long id);

}
