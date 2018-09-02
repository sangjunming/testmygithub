package com.yuanbao.park.service;

import java.util.List;

import com.yuanbao.park.common.req.StatisticsReqParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.entity.Statistics;

public interface StatisticsService {
		public CommonRespParam getstatisticsByParkIdAndYear(StatisticsReqParam statisticsReqParam);
}
