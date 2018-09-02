package com.yuanbao.park.service;

import com.yuanbao.park.common.req.PolicyReqParam;
import com.yuanbao.park.common.resp.CommonListRespParam;

public interface ConPolicyService {
    CommonListRespParam getAllPolicyInfo(PolicyReqParam policyReqParam);

    CommonListRespParam getCompanyNameInfo(Long id);
}
