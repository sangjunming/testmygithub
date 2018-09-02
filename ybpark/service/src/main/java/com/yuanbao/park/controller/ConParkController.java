package com.yuanbao.park.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.yuanbao.park.common.req.ParkReqParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConParkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * @author: XianKang
 * @description: 园区信息
 * @date: 10:58 2018/6/27
 * @param:  * @param null 
 * @return: 
 */
@Api("园区信息相关api")
@Controller
@RequestMapping("/park")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConParkController {
    private static Logger logger = LoggerFactory.getLogger(ConParkController.class);
    @Autowired
    private ConParkService conParkService;
    /**
     * @author: XianKang
     * @description: 获取园区信息
     * @date: 10:58 2018/6/26
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("获取园区信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query",name="id",dataType="companyServerReqParam",required=true,value="园区ID")})
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/find",method = RequestMethod.GET)
    @ResponseBody
    public CommonRespParam getParkInfoData(HttpServletRequest request, HttpServletResponse response, @RequestParam Long parkId){
        return conParkService.getParkServerInfoData(parkId);
    }
    
    /**
     * @author: XianKang
     * @description: 修改园区信息
     * @date: 10:58 2018/6/26
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("更新园区信息")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateParkInfoData(HttpServletRequest request, @ApiParam @RequestBody ParkReqParam parkReqParam){
    	return conParkService.updateParkInfoData(parkReqParam);
        
    }
    

}
