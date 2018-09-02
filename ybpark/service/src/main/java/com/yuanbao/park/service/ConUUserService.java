package com.yuanbao.park.service;

import com.yuanbao.park.common.req.UUserReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;

public interface ConUUserService {
    BaseRespParam updatePassword(String username, String oldPassword, String newPassword);

    CommonListRespParam queryUser(UUserReqParam uUserReqParam);
}
