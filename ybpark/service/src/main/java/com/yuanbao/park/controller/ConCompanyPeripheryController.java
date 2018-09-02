package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.*;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.service.ConCompanyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 企业周边信息视图层
 * @date: 2018-06-29 13:41
 * @param:
 */
@Controller
@Api("企业周边服务相关API")
@RequestMapping("/companyPeripheryServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConCompanyPeripheryController {

    @Autowired
    private ConCompanyService conCompanyService;

    /**
     * @author: CrazyZhou
     * @description: 查看企业资料信息
     * @date: 10:46 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业资料信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyArchiveInfo/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyArchiveInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyArchiveInfo(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业资料信息
     * @date: 10:41 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("删除企业资料信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/deleteCompanyArchiveInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteCompanyArchiveInfo(HttpServletRequest request, @PathVariable("id") Long id) {
        return conCompanyService.deleteCompanyArchiveInfo(id);
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业资料信息
     * @date: 10:33 2018/7/8
     * @param: * @param null
     * @return:
     */
    @ApiOperation("新增企业资料信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyArchiveInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyArchiveInfo(HttpServletRequest request, @RequestBody CompanyArchiveInfoReqParam companyArchiveInfoReqParam) {
        return conCompanyService.addCompanyArchiveInfo(companyArchiveInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查看企业经营信息
     * @date: 10:58 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业经营信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyOperateInfo/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyOperateInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyOperateInfo(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业经营信息
     * @date: 10:50 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("新增企业经营信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyOperateInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyOperateInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyOperateInfoReqParam companyOperateInfoReqParam) {
        return conCompanyService.addCompanyOperateInfo(companyOperateInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业经营信息
     * @date: 10:58 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业经营信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyOperateInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyOperateInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyOperateInfoReqParam companyOperateInfoReqParam) {
        return conCompanyService.updateCompanyOperateInfo(companyOperateInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业融资信息
     * @date: 18:32 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业融资信息信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyFinancingInfo/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyFinancingInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyFinancingInfo(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业融资信息
     * @date: 18:47 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加企业融资信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyFinancingInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyFinancingInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyFinancingReqParam companyFinancingReqParam) {
        return conCompanyService.addCompanyFinancingInfo(companyFinancingReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业融资信息
     * @date: 19:00 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("删除企业融资信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/delCompanyFinancingInfo/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam delCompanyFinancingInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.delCompanyFinancingInfo(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 查看企业人才统计信息
     * @date: 10:58 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查看企业人才统计信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyTalentStat/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyTalentStat(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyTalentStat(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业人才统计信息
     * @date: 11:11 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业人才统计信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyTalentStat/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam updateCompanyTalentStat(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyTalentReqParam companyTalentReqParam) {
        return conCompanyService.updateCompanyTalentStat(companyTalentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业人才统计信息
     * @date: 11:11 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加企业人才统计信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyTalentStat", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyTalentStat(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyTalentReqParam companyTalentReqParam) {
        return conCompanyService.addCompanyTalentStat(companyTalentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业团队(人才名单)信息
     * @date: 16:29 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业团队(人才名单)信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyTalentInfoList/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyTalentInfoList(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyTalentInfoList(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业团队(人才名单)信息
     * @date: 16:52 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业团队(人才名单)信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyTalentInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyTalentInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyTalentReqParam companyTalentReqParam) {
        return conCompanyService.updateCompanyTalentInfo(companyTalentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业团队(人才名单信息)
     * @date: 11:31 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("新增企业团队(人才名单信息)")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyTalentInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyTalentInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyTalentReqParam companyTalentReqParam) {
        return conCompanyService.addCompanyTalentInfo(companyTalentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业产品/项目信息列表以及产品信息详情
     * @date: 14:46 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询产品信息列表以及产品信息详情")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyProductInfoList", method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getCompanyProductInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyProductReqParam companyProductReqParam) {
        return conCompanyService.getCompanyProductInfo(companyProductReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加产品/项目详细信息
     * @date: 14:46 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加产品详细信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyProductInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyProductInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyProductReqParam companyProductReqParam) {
        return conCompanyService.addCompanyProductInfo(companyProductReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业产品/项目信息
     * @date: 11:38 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业产品/项目信息)")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyProductInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyProductInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyProductReqParam companyProductReqParam) {
        return conCompanyService.updateCompanyProductInfo(companyProductReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业专利信息统计列表
     * @date: 19:06 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业专利信息统计列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyPatentInfoList/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyPatentInfoList(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyPatentInfoList(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业专利统计信息
     * @date: 9:08 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业专利统计信息)")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyPatentInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyPatentInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyPatentReqParam companyPatentReqParam) {
        return conCompanyService.updateCompanyPatentInfo(companyPatentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业专利统计信息
     * @date: 9:24 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加企业专利统计信息)")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyPatentInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyPatentInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyPatentReqParam companyPatentReqParam) {
        return conCompanyService.addCompanyPatentInfo(companyPatentReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查看企业专利信息
     * @date: 10:59 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业知识产权信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyCopyrightInfo/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyCopyrightInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyCopyrightInfo(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 新增企业专利信息
     * @date: 13:59 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("新增企业专利信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyCopyrightInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyCopyrightInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyCopyrightReqParam companyCopyrightReqParam) {
        return conCompanyService.addCompanyCopyrightInfo(companyCopyrightReqParam);
    }


    /**
     * @author: CrazyZhou
     * @description: 修改企业专利信息
     * @date: 13:59 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业专利信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyCopyrightInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyCopyrightInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyCopyrightReqParam companyCopyrightReqParam) {
        return conCompanyService.updateCompanyCopyrightInfo(companyCopyrightReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查看企业需求信息
     * @date: 10:59 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业需求信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyDemandsInfoList/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyDemandsInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getCompanyDemandsInfo(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业需求信息
     * @date: 15:24 2018/7/8
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加企业需求信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyDemandsInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonRespParam addCompanyDemandsInfo(HttpServletRequest request, HttpServletResponse response,
                                                         @ApiParam @RequestBody CompanyDemandsReqParam companyDemandsReqParam) {
        return conCompanyService.addCompanyDemandsInfo(companyDemandsReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业需求信息
     * @date: 15:24 2018/7/8
     * @param:  * @param null
     * @return:
     */
    @ApiOperation("删除企业需求信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "需求ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/deleteCompanyDemandsInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteCompanyDemandsInfo(HttpServletRequest request, HttpServletResponse response,
                                                         @PathVariable("id") Long id) {
        return conCompanyService.deleteCompanyDemandsInfo(id);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业需求信息
     * @date: 15:25 2018/7/8
     * @param:  * @param null
     * @return:
     */
    @ApiOperation("修改企业需求信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateCompanyDemandsInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateCompanyDemandsInfo(HttpServletRequest request, HttpServletResponse response,
                                                  @ApiParam @RequestBody CompanyDemandsReqParam companyDemandsReqParam) {
        return conCompanyService.updateCompanyDemandsInfo(companyDemandsReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业融资信息
     * @date: 15:49 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业融资信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getOneCompanyFinancingInfo/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getOneCompanyFinancingInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getOneCompanyFinancingInfo(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业股东信息
     * @date: 15:54 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业股东信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getOneShareholderInformation/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getOneShareholderInformation(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getOneShareholderInformation(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业股东信息
     * @date: 16:15 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业股东信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateShareholderInformation", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateOneShareholderInformation(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        return conCompanyService.updateShareholderInformation(companyBasicInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业股东信息
     * @date: 16:16 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("删除企业股东信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/deleteShareholderInfomation/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteShareholderInfomation(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        return conCompanyService.deleteShareholderInfomation(id);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业股东信息
     * @date: 17:22 2018/7/5
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加企业股东信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addShareholderInfomation", method = RequestMethod.POST)
    @ResponseBody
    public CommonRespParam addShareholderInfomation(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        return conCompanyService.addShareholderInfomation(companyBasicInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业主要人员信息(员工信息)
     * @date: 15:59 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业主要人员信息(员工信息)")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getOneEmployeeInformation/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getOneEmployeeInformation(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId) {
        return conCompanyService.getOneEmployeeInformation(companyId);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业主要人员信息
     * @date: 16:16 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业主要人员信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateEmployeeInformation/{id}", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateEmployeeInformation(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        return conCompanyService.updateEmployeeInformation(companyBasicInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 删除企业主要人员信息
     * @date: 16:16 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("删除企业主要人员信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/deleteEmployeeInformation/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteEmployeeInformation(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {
        return conCompanyService.deleteEmployeeInformation(id);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业主要人员
     * @date: 17:32 2018/7/5
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加企业主要人员信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addEmployeeInformation", method = RequestMethod.POST)
    @ResponseBody
    public CommonRespParam addEmployeeInformation(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        return conCompanyService.addEmployeeInformation(companyBasicInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业产品导师信息
     * @date: 18:14 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业产品导师信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "productId", value = "产品ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getProductTeacherInfo/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getProductTeacherInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("productId") Long productId) {
        return conCompanyService.getProductTeacherInfo(productId);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业产品相关导师信息
     * @date: 18:14 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业产品相关导师信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateProductTeacherInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateProductTeacherInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody ProductTeacherReqParam productTeacherReqParam) {
        return conCompanyService.updateProductTeacherInfo(productTeacherReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 查看企业的新闻列表
     * @date: 9:48 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查看企业的新闻列表")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyNewsInfoList/{companyId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getCompanyNewsInfoList(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyNewsReqParam companyNewsReqParam) {
        return conCompanyService.getCompanyNewsInfoList(companyNewsReqParam);
    }


}
