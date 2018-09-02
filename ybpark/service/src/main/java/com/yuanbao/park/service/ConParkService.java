package com.yuanbao.park.service;

import com.yuanbao.park.common.req.ParkReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;

public interface ConParkService {

	CommonRespParam getParkServerInfoData(Long parkId);

	BaseRespParam updateParkInfoData(ParkReqParam parkReqParam);

	

}
