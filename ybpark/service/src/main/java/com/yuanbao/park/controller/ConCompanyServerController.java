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
import com.yuanbao.park.common.req.CompanyServerReqParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConCompanyServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author: XianKang
 * @description: 企业服务
 * @date: 10:58 2018/6/27
 * @param:  * @param null 
 * @return: 
 */
@Api("企业服务相关api")
@Controller
@RequestMapping("/companyServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConCompanyServerController {
    private static Logger logger = LoggerFactory.getLogger(ConCompanyServerController.class);
    @Autowired
    private ConCompanyServerService conCompanyServerService;
    
    /**
     * @author: XianKang
     * @description: 获取企业服务
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("获取企业服务信息")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/findCompanyServerInfoData",method=RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getCompanyServerInfoData(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyServerReqParam companyServerReqParam){
    	return conCompanyServerService.getCompanyServerInfoData(companyServerReqParam);
    }
    
    /**
     * @author: XianKang
     * @description: 企业服务增加
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("增加企业服务信息")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/insertCompanyServerInfoData",method=RequestMethod.POST)
    @ResponseBody
    public BaseRespParam insertCompanyServerInfoData(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody CompanyServerReqParam companyServerReqParam){
    	return conCompanyServerService.insertCompanyServerInfoData(companyServerReqParam);
    }
    
    /**
     * @author: XianKang
     * @description: 企业服务更新
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("更新企业服务信息")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/updateCompanyServerInfoData",method=RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyServerInfoData(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody CompanyServerReqParam companyServerReqParam){
    	return conCompanyServerService.updateCompanyServerInfoData(companyServerReqParam);
    }
    
    /**
     * @author: XianKang
     * @description: 删除企业服务
     * @date: 10:58 2018/6/27
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("删除企业服务信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType="delete",name="companyServerReqParam",dataType="companyServerReqParam",required=true,value="企业服务id")})
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/deleteCompanyServerInfoData",method=RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteCompanyServerInfoData(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id){
    	return conCompanyServerService.deleteCompanyServerInfoData(id);
    }
	

}
