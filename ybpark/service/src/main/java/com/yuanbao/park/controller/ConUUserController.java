package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.UUserReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.service.ConUUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xiankang
 * @Date: 2018/7/9 10:42
 * @Description:用户信息管理
 * @Problem:
 * @Return:
 */
@Controller
@Api("用户信息相关API")
@RequestMapping("/uUser")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConUUserController {


    @Autowired
    private ConUUserService conUUserService;
    /**
     * @Author: xiankang
     * @Date: 2018/7/9 10:44
     * @Description:修改密码
     * @Problem:
     * @Return:
     */
    @ApiOperation("修改用户密码")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "update", dataType = "String", name = "username", value = "用户名"),
            @ApiImplicitParam(paramType = "update", dataType = "String", name = "oldPassword", value = "旧密码"),
            @ApiImplicitParam(paramType = "update", dataType = "String", name = "newPassword", value = "新密码")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam updatePassword(HttpServletRequest request, HttpServletResponse response, String username, String oldPassword, String newPassword) {
        return conUUserService.updatePassword(username,oldPassword,newPassword);
    }

    /**
     * @Author: xiankang
     * @Date: 2018/7/9 14:37
     * @Description:用户管理查询（可条件查询）
     * @Problem:
     * @Return:
     */
    @ApiOperation("用户管理查询")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value="/query",method = RequestMethod.GET)
    @ResponseBody
    public CommonListRespParam queryUser(HttpServletRequest request, HttpServletResponse response, @RequestParam UUserReqParam uUserReqParam){
        return conUUserService.queryUser(uUserReqParam);
    }


}
