package com.yuanbao.park.controller;

import com.yuanbao.park.common.req.ParkUserReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.respPojo.ParkUserInfoData;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.entity.ParkUser;
import com.yuanbao.park.service.ParkUserService;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: xiankang
 * @Date: 2018/7/3 11:51
 * @Description:暂时用于园区登陆系统
 * @Problem:
 * @Return:
 */
@RestController
@Api("园区用户登陆相关api")
@RequestMapping("/parkUser")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConParkUserController {
    @Autowired
    private ParkUserService parkUserService;

    /**
     * @Author: xiankang
     * @Date: 2018/7/3 11:55
     * @Description:园区登陆
     * @Problem:
     * @Return:
     */

    @ApiOperation("园区用户登陆")
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseRespParam getParkUser(HttpServletRequest request, HttpServletResponse response,  @ApiParam @RequestBody ParkUserReqParam parkUserReqParam) {
          BaseRespParam parkUser = parkUserService.getParkUser(request, parkUserReqParam);
         return parkUser;
    }

    
}
