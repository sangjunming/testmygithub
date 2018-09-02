package com.yuanbao.park.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.yuanbao.park.common.req.CompanyServiceAndActivitiesReqParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConCompanyServerAndActivitiesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @author: XianKang
 * @description: 服务与活动
 * @date: 10:58 2018/6/27
 * @param:  * @param null 
 * @return: 
 */
@Api("服务与活动相关api")
@Controller
@RequestMapping("/companyServerAndActivities")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConCompanyServerAndActivitiesController {
    @Autowired
    private ConCompanyServerAndActivitiesService conCompanyServerAndActivitiesService;
    
    /**
     * @author: XianKang
     * @description: 服务与活动的分页查找功能
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("查找获取企业服务")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/findpage",method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getCompanyServerAndActivitiesInfoData(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyServiceAndActivitiesReqParam companyServerAndActivitiesReqParam){
        return conCompanyServerAndActivitiesService.getCompanyServerAndActivitiesInfoData(companyServerAndActivitiesReqParam);
    }
    
    /**
     * @author: XianKang
     * @description: 服务与活动的更新功能
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("更新企业服务")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/update",method= RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyServerAndActivitiesInfoData(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody CompanyServiceAndActivitiesReqParam companyServerAndActivitiesReqParam){
        return conCompanyServerAndActivitiesService.updataCompanyServerAndActivitiesInfoData(companyServerAndActivitiesReqParam);
    }
    
    /**
     * @author: XianKang
     * @description: 服务与活动的删除功能
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("删除企业服务")
    @ApiImplicitParams({@ApiImplicitParam(paramType="delete",name="id",dataType="Long",required=true,value="服务活动id")})
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/delete",method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteCompanyServerAndActivitiesInfoData(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id){
        return conCompanyServerAndActivitiesService.deleteCompanyServerAndActivitiesInfoData(id);
    }
    
    /**
     * @author: XianKang
     * @description: 服务与活动添加功能
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("添加企业服务")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/insert",method=RequestMethod.POST)
    @ResponseBody
    public BaseRespParam insertCompanyServerAndActivitiesInfoData(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody CompanyServiceAndActivitiesReqParam companyServerAndActivitiesReqParam){
        return conCompanyServerAndActivitiesService.insertCompanyServerAndActivitiesInfoData(companyServerAndActivitiesReqParam);
    }
    
    
	

}
