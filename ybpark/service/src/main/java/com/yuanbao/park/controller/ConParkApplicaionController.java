package com.yuanbao.park.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuanbao.park.common.resp.CommonListRespParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yuanbao.park.common.req.ParkApplicationReqParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConParkApplicaionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * @author: XianKang
 * @description: 园区入驻信息，此处功能尚未完全，缺少入住企业详细信息,下周补全
 * @date: 10:58 2018/6/26
 * @param:  * @param null 
 * @return: 
 */
@RestController
@Api("园区入驻相关api")
@RequestMapping("/parkApplication")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConParkApplicaionController {
	@Autowired
	private ConParkApplicaionService conParkApplicaionService;
	
	/**
	 * @author: XianKang
	 * @description: 园区入驻信息查询
	 * @date: 10:58 2018/6/26
	 * @param:  * @param null 
	 * @return: 
	 */
    @ApiOperation("获取入驻企业信息")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getParkApplicationInfo",method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getParkApplicationInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody ParkApplicationReqParam parkApplicationReqParam){
        return conParkApplicaionService.getParkApplicationInfo(parkApplicationReqParam);
    }

    
	

}
