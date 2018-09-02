package com.yuanbao.park.controller;

import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConParkIconService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: CrazyZhou
 * @description: 园区图谱视图层
 * @date: 2018-07-02 10:09
 * @param:
 */
@Controller
@Api("园区图谱相关API")
@RequestMapping("/parkIconServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConParkIconController {
    
    @Autowired
    private ConParkIconService conParkIconService;
    
    /**
     * @author: CrazyZhou
     * @description: 统计园区各类型企业总数
     * @date: 15:19 2018/7/2
     * @param:  * @param null 
     * @return: 
     */
    @ApiOperation("统计园区各类型企业数量")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/countCompanyTypeAmount",method = RequestMethod.POST)
    @ResponseBody
    public ResultData countCompanyTypeAmount(HttpServletRequest request, HttpServletResponse response){
        return conParkIconService.countCompanyTypeAmount();
    }
}
