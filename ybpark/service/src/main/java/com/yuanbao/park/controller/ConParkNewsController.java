package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.ParkNewsReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.service.ConParkNewsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xiankang
 * @Date: 2018/7/5 17:27
 * @Description:园区新闻
 * @Problem:
 * @Return:
 */
@Controller
@Api("园区新闻相关API")
@RequestMapping("/parkNewsServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConParkNewsController {
    @Autowired
    private ConParkNewsService conParkNewsService;
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 17:45
     * @Description: 添加发布园区新闻或者添加新闻草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("添加发布园区新闻或添加新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/addParkNewsInfoOrDraft", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam addParkNewsInfoOrDraft(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody ParkNewsReqParam parkNewsReqParam) {
        return conParkNewsService.addParkNewsInfoOrDraft(parkNewsReqParam);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 17:48
     * @Description: 查询园区所有已发布新闻(可以根据条件查询)或所有草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("查询园区所有已发布新闻(可以根据条件查询)或所有草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/getAllParkNewsInfoOrAllDraft", method = RequestMethod.POST)
    @ResponseBody
    public CommonListRespParam getAllParkNewsInfoOrAllDraft(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody ParkNewsReqParam parkNewsReqParam) {
        return conParkNewsService.getAllParkNewsInfoOrAllDraft(parkNewsReqParam);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 17:56
     * @Description:发布园区新闻草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("发布园区新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({@ApiImplicitParam(paramType="update",name="id",dataType="Long",required=true,value="园区新闻id")})
    @RequestMapping(value = "/releaseParkNewsInfoDraft", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam releaseParkNewsInfoDraft(HttpServletRequest request, HttpServletResponse response,  @RequestParam("id") Long id) {
        return conParkNewsService.releaseParkNewsInfoDraft(id);
    }
    
    /**
     * @Author: xiankang
     * @Date: 2018/7/5 17:58
     * @Description:修改园区新闻草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("修改园区新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updateParkNewsInfoDraft", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updateParkNewsInfoDraft(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody ParkNewsReqParam parkNewsReqParam) {
        return conParkNewsService.updateParkNewsInfoDraft(parkNewsReqParam);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 18:01
     * @Description:删除园区新闻草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("删除园区新闻草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({@ApiImplicitParam(paramType="delete",name="id",dataType="Long",required=true,value="园区新闻id")})
    @RequestMapping(value = "/deleteParkNewsInfoDraft", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam deleteParkNewsInfoDraft(HttpServletRequest request, HttpServletResponse response,   @RequestParam Long id) {
        return conParkNewsService.deleteParkNewsInfoDraft(id);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/5 18:02
     * @Description:将发布的园区新闻添加至草稿
     * @Problem:
     * @Return:
     */
    @ApiOperation("将发布的园区新闻添加为草稿")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @ApiImplicitParams({@ApiImplicitParam(paramType="update",name="id",dataType="Long",required=true,value="园区新闻id")})
    @RequestMapping(value = "/parkNewsToParkNewsInfoDraft", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespParam parkNewsToParkNewsInfoDraft(HttpServletRequest request, HttpServletResponse response,  @RequestParam Long id) {
        return conParkNewsService.parkNewsToParkNewsInfoDraft(id);
    }
}
