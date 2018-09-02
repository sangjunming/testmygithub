package com.yuanbao.park.service;

import com.yuanbao.park.common.req.ParkApplicationReqParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;

public interface ConParkApplicaionService {

	CommonListRespParam getParkApplicationInfo(ParkApplicationReqParam parkApplicationReqParam);
	
}
