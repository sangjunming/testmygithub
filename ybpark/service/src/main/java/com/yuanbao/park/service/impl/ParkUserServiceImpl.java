package com.yuanbao.park.service.impl;

import com.yuanbao.park.common.req.ParkUserReqParam;
import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonListRespParam;
import com.yuanbao.park.common.respPojo.ParkUserInfoData;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import com.yuanbao.park.dao.master.ParkUserMapper;
import com.yuanbao.park.entity.ParkUser;
import com.yuanbao.park.service.ParkUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: xiankang
 * @Date: 2018/7/3 13:48
 * @Description:用户登陆界面的持久化层
 * @Problem:
 * @Return:
 */
@Service
public class ParkUserServiceImpl implements ParkUserService {

    private static Logger logger = LoggerFactory.getLogger(ParkUserServiceImpl.class);
    @Autowired
    private ParkUserMapper parkUserMapper;

    /**
     * @Author: xiankang
     * @Date: 2018/7/3 14:59
     * @Description:用户登陆功能
     * @Problem:
     * @Return:
     */
    @Override
    public BaseRespParam getParkUser(HttpServletRequest request, ParkUserReqParam parkUserReqParam) {
        BaseRespParam baseRespParam = new BaseRespParam();
        Example example = new Example(ParkUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", parkUserReqParam.getUsername());
        criteria.andEqualTo("password", parkUserReqParam.getPassword());
        List<ParkUser> parkUsers = parkUserMapper.selectByExample(example);
        ParkUserInfoData parkUserInfoData = new ParkUserInfoData();
        try {
            if (MyCollectionsUtils.isNotEmpty(parkUsers)) {
                ParkUser user = parkUsers.get(0);
                BeanUtils.copyProperties(user, parkUserInfoData);
                request.setAttribute("parkUser", parkUserInfoData);
                return baseRespParam;
            } else {
                baseRespParam.setResultCode(Message.FAILURE_CODE);
                baseRespParam.setResultMsg(Message.FAILURE );
                return baseRespParam;
            }
        } catch (BeansException e) {
            logger.error(e.getMessage(), e);
            baseRespParam.setResultCode(Message.FAILURE_CODE);
            baseRespParam.setResultMsg(Message.FAILURE );
            return baseRespParam;
        }
    }
}
