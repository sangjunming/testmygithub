package com.yuanbao.park.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuanbao.park.common.req.StatisticsReqParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yuanbao.park.common.req.CompanyServerReqParam;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.resultUtils.SystemException;
import com.yuanbao.park.entity.Ceshi;
import com.yuanbao.park.entity.Statistics;
import com.yuanbao.park.service.StatisticsService;
import com.yuanbao.park.service.TestService;

@RestController
@Api("园区管理-园区统计:相关api")
@RequestMapping("/statistics")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    
    /**
     * 根据公司ID查询园区统计信息
     * @param
     */
    @ApiOperation("根据parkId查询园区统计")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @ResponseBody
    @RequestMapping(value = "/query/getstatisticsByCompanyId", method = RequestMethod.POST)
    public CommonRespParam getStatisticsByParkIdAndYear(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody StatisticsReqParam statisticsReqParam) {
        CommonRespParam commonRespParam=statisticsService.getstatisticsByParkIdAndYear(statisticsReqParam);
        return commonRespParam;
    }
    
}
