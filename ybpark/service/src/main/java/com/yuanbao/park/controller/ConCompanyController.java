package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.*;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConCompanyService;
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
 * @description: 企业相关信息视图层
 * @date: 2018-06-25 19:44
 * @param:
 */
@RestController
@Api("企业基本信息相关API")
@RequestMapping("/companyServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConCompanyController {

    private static Logger logger = LoggerFactory.getLogger(ConCompanyController.class);

    @Autowired
    private ConCompanyService conCompanyService;

    /**
     * @author: CrazyZhou
     * @description: 查询企业基本信息
     * @date: 15:36 2018/6/26
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业基本信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "Long", name = "companyId", value = "公司ID"),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "parkId", value = "园区ID")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getOneCompanyInfo/{companyId}/{parkId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getOneCompanyInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Long companyId, @PathVariable("parkId") Long parkId) {
        return conCompanyService.getOneCompanyInfo(companyId, parkId);
    }

    /**
     * @author: CrazyZhou
     * @description: 修改企业基本信息
     * @date: 10:25 2018/6/29
     * @param: * @param null
     * @return:
     */
    @ApiOperation("修改企业基本信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateOneCompanyInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateOneCompanyInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        return conCompanyService.updateOneCompanyInfo(companyBasicInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业基本信息
     * @date: 11:33 2018/6/27
     * @param: * @param null
     * @return:
     */
    @ApiOperation("添加企业基本信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addCompanyBasicInfo", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addCompanyBasicInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        return conCompanyService.addCompanyBasicInfo(companyBasicInfoReqParam);
    }

    /**
     * @author: CrazyZhou
     * @description: 添加企业基本信息时根据企业名称判断是否存在重名
     * @date: 14:25 2018/7/5
     * @param:  * @param null
     * @return:
     */
    @ApiOperation("判断企业名称是否重名")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/judgeCompanyNameWhetherRepeat/{companyName}/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam judgeCompanyNameWhetherRepeat(HttpServletRequest request, HttpServletResponse response,
                                                       @PathVariable("companyName") String companyName,@PathVariable("id") Long id){
        return conCompanyService.judgeCompanyNameWhetherRepeat(companyName,id);
    }

    /**
     * @author: CrazyZhou
     * @description: 查询企业基本信息列表
     * @date: 14:54 2018/6/28
     * @param: * @param null
     * @return:
     */
    @ApiOperation("查询企业基本信息列表")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyInfoList", method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getCompanyInfoList(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody CompanyBasicInfoReqParam companyBasicInfoReqParam) {
        CommonListRespParam commonListRespParam = conCompanyService.getCompanyInfoList(companyBasicInfoReqParam);
        return commonListRespParam;
    }
}
