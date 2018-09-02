package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.CompanyNewsReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConCompanyNewsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: CrazyZhou
 * @description: 企业新闻视图层
 * @date: 2018-06-27 17:16
 * @param:
 */
@Controller
@Api("企业新闻相关API")
@RequestMapping("/companyNewsServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConCompanyNewsController {

    @Autowired
    private ConCompanyNewsService companyNewsService;

    /**
     * @author: CrazyZhou
     * @description: 添加发布企业新闻或添加企业新闻草稿
     * @date: 17:45 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加发布企业新闻或添加企业新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyNewsInfoOrDraft", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyNewsInfoOrDraft(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyNewsReqParam companyNewsReqParam) {
        return companyNewsService.addCompanyNewsInfoOrDraft(companyNewsReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询园区所有发布企业新闻或所有企业新闻草稿
     * @date: 17:47 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询园区所有发布企业新闻或所有企业新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getAllCompanyNewsInfoOrDraft", method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getAllCompanyNewsInfoOrDraft(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyNewsReqParam companyNewsReqParam) {
        return companyNewsService.getAllCompanyNewsInfoOrDraft(companyNewsReqParam);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 11:23
     * @Description:发布企业新闻草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("发布企业新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "update", name = "id", dataType = "Long", required = true, value = "企业新闻id")})
    @RequestMapping(value = "/releaseCompanyNewsInfoDraft", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam releaseCompanyNewsInfoDraft(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Long id) {
        return companyNewsService.releaseCompanyNewsInfoDraft(id);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 11:46
     * @Description:修改企业新闻草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("修改企业新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyNewsInfoDraft", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyNewsInfoDraft(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyNewsReqParam companyNewsReqParam) {
        return companyNewsService.updateCompanyNewsInfoDraft(companyNewsReqParam);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 11:48
     * @Description:删除企业新闻草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("删除企业新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "delete", name = "id", dataType = "Long", required = true, value = "企业新闻id")})
    @RequestMapping(value = "/deleteCompanyNewsInfoDraft", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteCompanyNewsInfoDraft(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id) {
        return companyNewsService.deleteCompanyNewsInfoDraft(id);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 11:51
     * @Description:将发布的企业新闻添加为草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("将发布的企业新闻添加为草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({@ApiImplicitParam(paramType = "update", name = "id", dataType = "Long", required = true, value = "企业新闻id")})
    @RequestMapping(value = "/companyNewsToCompanyNewsInfoDraft", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam companyNewsToCompanyNewsInfoDraft(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id) {
        return companyNewsService.companyNewsToCompanyNewsInfoDraft(id);
    }
}
