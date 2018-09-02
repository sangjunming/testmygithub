package com.yuanbao.park.controller;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.entity.UPermission;
import com.yuanbao.park.entity.URole;
import com.yuanbao.park.entity.UUser;
import com.yuanbao.park.service.UUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api("登录/注销API")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class loginController {

    private static Logger logger = LoggerFactory.getLogger(loginController.class);

    @Autowired
    private UUserService uUserService;

    @ApiOperation("用户登录")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        CommonRespParam commonRespParam = new CommonRespParam();
        try {
            //校验参数
            if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                commonRespParam.setResultCode(Message.FAILURE_CODE);
                commonRespParam.setResultMsg(Message.USERNAME_OR_PASSWORD_ERROR);
                commonRespParam.setDataInfo(null);
                return commonRespParam;
            }

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            //验证是否登录成功
            if (currentUser.isAuthenticated()) {
                Map<String, Object> result = new HashMap<String, Object>();
                UUser user = uUserService.findByName(username);
                List<UPermission> plist = uUserService.findUPermissionByUid(user.getId());
                List<URole> rlist = uUserService.findURoleByUid(user.getId());
                result.put("user", user);
                result.put("permission", plist);
                result.put("role", rlist);

                commonRespParam.setResultCode(Message.SUCCESS_CODE);
                commonRespParam.setResultMsg(Message.SUCCESS);
                commonRespParam.setDataInfo(result != null ? result : null);
            } else {
                commonRespParam.setResultCode(Message.FAILURE_CODE);
                commonRespParam.setResultMsg("用户校验出错！！！");
            }
        } catch (Exception e) {
            commonRespParam.setResultCode(Message.SUCCESS_CODE);
            commonRespParam.setResultMsg(Message.SYSTEM_UNKNOWN_ERROR);
            commonRespParam.setDataInfo(null);
        }

        return commonRespParam;
    }

    @ApiOperation("用户注销")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Object logout(HttpServletRequest request, HttpServletResponse response, String username) {
        CommonRespParam commonRespParam = new CommonRespParam();
        try {
            //校验参数
            if (StringUtils.isBlank(username)) {
                commonRespParam.setResultCode(Message.FAILURE_CODE);
                commonRespParam.setResultMsg("用户名错误！！！");
                commonRespParam.setDataInfo(null);
                return commonRespParam;
            }

            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            //验证是否登录成功
            if (!currentUser.isAuthenticated()) {
                commonRespParam.setResultCode(Message.SUCCESS_CODE);
                commonRespParam.setResultMsg("注销成功！！！");
            } else {
                commonRespParam.setResultCode(Message.FAILURE_CODE);
                commonRespParam.setResultMsg("注销失败！！！");
            }

        } catch (Exception e) {
            commonRespParam.setResultCode(Message.FAILURE_CODE);
            commonRespParam.setResultMsg("注销失败！！！");
            commonRespParam.setDataInfo(null);
        }
        return commonRespParam;
    }
}

