package com.yuanbao.park.service;

import com.yuanbao.park.common.req.ParkNewsReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;

public interface ConParkNewsService {
    BaseRespParam addParkNewsInfoOrDraft(ParkNewsReqParam parkNewsReqParam);

    CommonListRespParam getAllParkNewsInfoOrAllDraft(ParkNewsReqParam parkNewsReqParam);

    BaseRespParam releaseParkNewsInfoDraft(Long id);

    BaseRespParam updateParkNewsInfoDraft(ParkNewsReqParam parkNewsReqParam);

    BaseRespParam deleteParkNewsInfoDraft(Long id);

    BaseRespParam parkNewsToParkNewsInfoDraft(Long id);
}
