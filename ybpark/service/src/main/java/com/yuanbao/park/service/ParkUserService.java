package com.yuanbao.park.service;

import com.yuanbao.park.common.req.ParkUserReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.entity.ParkUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ParkUserService {
    BaseRespParam getParkUser(HttpServletRequest request, ParkUserReqParam parkUserReqParam);
}
