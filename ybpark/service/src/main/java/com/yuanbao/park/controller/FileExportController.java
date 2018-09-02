package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.CompanyBasicInfoReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConCompanyService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: CrazyZhou
 * @description: 打印,导出文件
 * @date: 2018-06-28 10:06
 * @param:
 */
@Api("导出文件相关接口")
@Controller
@RequestMapping("/exportFile")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileExportController{

    @Autowired
    private ConCompanyService conCompanyService;

    /**
     * @author: CrazyZhou
     * @description: 导出企业基本信息
     * @date: 14:51 2018/6/28
     * @param:  * @param null
     * @return:
     */
    @ApiOperation(value = "导出公司信息的excel文档",produces = "application/octet-stream")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query",name="companyName",dataType="String",value="公司名称")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/exportCompanyInfoList",method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam exportCompanyInfoList(HttpServletRequest request, HttpServletResponse response,   CompanyBasicInfoReqParam companyBasicInfoReqParam){
        return conCompanyService.exportCompanyInfoList(response,companyBasicInfoReqParam);
    }
}
