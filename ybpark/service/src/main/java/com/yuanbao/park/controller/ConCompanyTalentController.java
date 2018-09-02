package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.CompanyTalentReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConCompanyTalentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: CrazyZhou
 * @description: 企业人才视图层
 * @date: 2018-06-27 19:02
 * @param:
 */
@Controller
@Api("企业人才信息相关API")
@RequestMapping("/CompanyTalentService")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConCompanyTalentController {

    @Autowired
    private ConCompanyTalentService conCompanyTalentService;

    /**
     * @author: CrazyZhou
     * @description: 添加人才信息
     * @date: 19:08 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @ApiOperation("添加人才信息")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompannyTalent",method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompannyTalent(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyTalentReqParam companyTalentReqParam){
        return conCompanyTalentService.addCompanyTalent(companyTalentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询园区所有人才信息
     * @date: 19:09 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @ApiOperation("查询园区所有人才信息")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getAllCompannyTalent",method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getAllCompannyTalent(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody CompanyTalentReqParam companyTalentReqParam){
        return conCompanyTalentService.getAllCompannyTalent(companyTalentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 删除人才信息
     * @date: 19:09 2018/6/27
     * @param:  * @param null
     * @return:
     */
    @ApiOperation("删除人才信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",dataType = "Long",name = "id",value = "人才信息ID")})
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"), @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getAllCompannyTalent/id",method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam deleteCompannyTalent(HttpServletRequest request, HttpServletResponse response,  @PathVariable("id") Long id){
        return conCompanyTalentService.deleteCompannyTalent(id);
    }

}
