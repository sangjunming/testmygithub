package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.CompanyNewsReqParam;
import com.yuanbao.park.common.req.PolicyReqParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.service.ConPolicyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xiankang
 * @Date: 2018/7/6 11:21
 * @Description:政策信息
 * @Problem:
 * @Return:
 */
@Controller
@Api("政策信息相关API")
@RequestMapping("/companyNewsServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConPolicyController {
    @Autowired
    private ConPolicyService conPolicyService;

    /**
     * @Author: xiankang
     * @Date: 2018/7/6 11:28
     * @Description:查询所有政策信息(可以根据条件查询)
     * @Problem:
     * @Return:
     */
    @ApiOperation("查询所有政策信息(可以根据条件查询)")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getAllPolicyInfo", method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getAllPolicyInfo(HttpServletRequest request, HttpServletResponse response, @ApiParam @RequestBody PolicyReqParam policyReqParam) {
        return conPolicyService.getAllPolicyInfo(policyReqParam);
    }
    
    /**
     * @Author: xiankang
     * @Date: 2018/7/6 11:29
     * @Description:查询政策相关企业
     * @Problem:
     * @Return:
     */
    @ApiOperation("查询政策新闻对应的企业")
    @ApiImplicitParams(@ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "政策新闻ID"))
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getCompanyNameInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getCompanyNameInfo(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id) {
        return conPolicyService.getCompanyNameInfo(id);
    }

}
