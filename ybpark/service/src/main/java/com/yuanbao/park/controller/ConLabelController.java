package com.yuanbao.park.controller;

import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.service.ConLabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: CrazyZhou
 * @description: 标签信息视图层
 * @date: 2018-06-28 14:33
 * @param:
 */
@Controller
@Api("标签信息相关API")
@RequestMapping("/labelServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConLabelController {

    @Autowired
    private ConLabelService conLabelService;

    /**
     * @author: CrazyZhou
     * @description: 获取标签列表的接口
     * @date: 14:39 2018/6/28
     * @param:  * @param null
     * @return: deleteType 标签类型
     */
    @ApiOperation("获取标签列表的接口")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",dataType = "int",value = "标签类型",required = true)})
    @RequestMapping(value = "/getLabelInfoList/{labelType}",method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam getLabelInfoList(HttpServletRequest request, HttpServletResponse response, @PathVariable("labelType") Integer labelType){
        return conLabelService.getLabelInfoList(labelType);
    }
}
