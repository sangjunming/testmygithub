package com.yuanbao.park.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.resultUtils.SystemException;
import com.yuanbao.park.entity.Ceshi;
import com.yuanbao.park.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api("testController相关api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {

	private static Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
    @Autowired
    private TestService testService;

    /**
     *测试
     * @param test
     * @return
     */
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType="query",name="test",dataType="String",required=true,value="测试参数",defaultValue="wangna")})
    @ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),@ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")})
    @ResponseBody
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public ResultData apitest(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "test", required = true) String test) {
    	  ResultData resultData ;
          try {
              //校验
              if(null==test){
                  throw new SystemException(MessageEnum.PARMA_FORMAT_ERROR);
              } 

              //业务
              List<Ceshi> list = testService.findCeshiList();
              resultData = new ResultData(MessageEnum.SUCCESS,list);
          }catch (Exception e) {
              logger.error(e.getMessage(), e);
              resultData=new ResultData(e);
          }
          return resultData;
    }

    @RequestMapping(value = "/api/insert",method = RequestMethod.GET)
    @ResponseBody
    public ResultData insert(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "test", required = true) String test){
        Ceshi ceshi = new Ceshi();
        ceshi.setTest(test);
        Ceshi ceshi1 = testService.insert(ceshi);
        ResultData resultData = new ResultData(MessageEnum.SUCCESS, ceshi1);
        return resultData;
    }
    
}
