package com.yuanbao.park.service.impl;

import com.github.pagehelper.PageHelper;
import com.yuanbao.park.common.req.UUserReqParam;
import com.yuanbao.park.common.resp.BasePageParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.utils.BasePageRespParamsUtils;
import com.yuanbao.park.common.utils.MyStringUtils;
import com.yuanbao.park.dao.master.UUserMapper;
import com.yuanbao.park.entity.ParkNews;
import com.yuanbao.park.entity.UUser;
import com.yuanbao.park.service.ConUUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @Author: xiankang
 * @Date: 2018/7/9 11:05
 * @Description:用户信息持久化层
 * @Problem:
 * @Return:
 */
@Service
public class ConUUserServiceImpl implements ConUUserService {

    private static Logger logger = LoggerFactory.getLogger(ConUUserServiceImpl.class);
    @Autowired
    private Environment environment;

    @Autowired
    private UUserMapper uUserMapper;
    /**
     * @Author: xiankang
     * @Date: 2018/7/9 11:37
     * @Description:修改密码
     * @Problem:
     * @Return:
     */

    @Override
    public BaseRespParam updatePassword(String username, String oldPassword, String newPassword) {
        BaseRespParam baseRespParam=new BaseRespParam();
        //参数校验
        if (StringUtils.isBlank(username) || StringUtils.isBlank(oldPassword)||StringUtils.isBlank(newPassword)) {
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.USERNAME_OR_PASSWORD_ERROR);;
            return baseRespParam;
        }

        try {
            UUser user = uUserMapper.selectUUserByName(username);
            if (user.getPassword().equals(oldPassword)){
                Example userExample=new Example(UUser.class);
                Example.Criteria userExampleCriteria = userExample.createCriteria();
                userExampleCriteria.andEqualTo("name",username);
                user.setPassword(newPassword);
                user.setUpdatetime(new Date());
                int isOk = uUserMapper.updateByExampleSelective(user,userExample);
                if (isOk > 0) {
                    return baseRespParam;
                } else {
                    baseRespParam.setResultCode(Message.FAILURE_CODE);
                    baseRespParam.setResultMsg(Message.FAILURE);
                    return baseRespParam;
                }
            }else{
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE);
                return baseRespParam;
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            baseRespParam.setResultCode(Message.SUCCESS_CODE);
            baseRespParam.setResultMsg(Message.SYSTEM_UNKNOWN_ERROR);
            return baseRespParam;
        }

    }
    /**
     * @Author: xiankang
     * @Date: 2018/7/9 14:44
     * @Description:用户管理查询
     * @Problem:
     * @Return:
     */
    @Override
    public CommonListRespParam queryUser(UUserReqParam uUserReqParam) {
        CommonListRespParam CommonListRespParam=new CommonListRespParam();
        //组装查询条件

        return null;
    }
}
