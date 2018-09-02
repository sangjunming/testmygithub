package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.IndustryNewsReqParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConIndustryNewsService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: CrazyZhou
 * @description: 行业新闻视图层
 * @date: created in 16:14 2018/6/25
 * @param:
 */
@Controller
@Api("行业新闻相关API")
@RequestMapping("/industryNewsServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConIndustryNewsController {

    @Autowired
    private ConIndustryNewsService conIndustryNewsService;

    private static Logger logger = LoggerFactory.getLogger(ConIndustryNewsController.class);

    /**
     * @author: CrazyZhou
     * @description: 查询所有行业新闻
     * @date: 18:43 2018/6/25
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("查询所有行业新闻")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getIndustryNewsInfo",method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getIndustryNewsInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody IndustryNewsReqParam industryNewsReqParam){
        return conIndustryNewsService.getIndustryNewsInfo(industryNewsReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 从爬虫部获取行业新闻详情
     * @date: 19:36 2018/6/25
     * @param:  * @param null
     * @return:
     */

}
