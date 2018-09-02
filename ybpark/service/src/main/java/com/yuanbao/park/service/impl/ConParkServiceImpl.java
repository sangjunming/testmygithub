package com.yuanbao.park.service.impl;

import com.yuanbao.park.common.resp.BaseRespParam;
import com.yuanbao.park.common.resp.CommonRespParam;
import com.yuanbao.park.common.resultUtils.Message;
import com.yuanbao.park.common.utils.MyCollectionsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanbao.park.common.req.ParkReqParam;
import com.yuanbao.park.common.respPojo.ParkInfoData;
import com.yuanbao.park.common.resultUtils.MessageEnum;
import com.yuanbao.park.common.resultUtils.ResultData;
import com.yuanbao.park.dao.master.ParkMapper;
import com.yuanbao.park.entity.CompanyTalent;
import com.yuanbao.park.entity.Park;
import com.yuanbao.park.service.ConParkService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: XianKang
 * @description: 园区信息持久化层
 * @date: 10:58 2018/6/26
 * @param:  * @param null 
 * @return: 
 */
@Service
public class ConParkServiceImpl implements ConParkService{
	private static Logger logger = LoggerFactory.getLogger(ConParkServiceImpl.class);
	@Autowired
	private ParkMapper parkMapper;
	
	/**
	 * @author: XianKang
	 * @description: 获取园区信息
	 * @date: 10:58 2018/6/26
	 * @param:  * @param null 
	 * @return: 
	 */
	@Override
	public CommonRespParam getParkServerInfoData(Long parkId) {
		CommonRespParam commonRespParam=new CommonRespParam();
		try {
			Example parkExample=new Example(Park.class);
			parkExample.createCriteria().andEqualTo("parkId", parkId);
			List<Park> parks = parkMapper.selectByExample(parkExample);
			if (MyCollectionsUtils.isNotEmpty(parks)){
                commonRespParam.setDataInfo(parks.get(0));
            }else{
				commonRespParam.setResultMsg(Message.FAILURE);
				commonRespParam.setResultCode(Message.FAILURE_CODE);
            }
			return commonRespParam;
		} catch (Exception e) {
			logger.info(e.getMessage(),e);
			commonRespParam.setResultMsg(Message.FAILURE);
			commonRespParam.setResultCode(Message.FAILURE_CODE);
			return commonRespParam;
		}

	}
	
	/**
	 * @author: XianKang
	 * @description: 更新园区信息
	 * @date: 10:58 2018/6/26
	 * @param:  * @param null 
	 * @return: 
	 */
	@Override
	public BaseRespParam updateParkInfoData(ParkReqParam parkReqParam) {
		CommonRespParam commonRespParam=new CommonRespParam();
        Park park = new Park();
        BeanUtils.copyProperties(parkReqParam,park);
        int isOk = parkMapper.updateByPrimaryKey(park);
        if (isOk > 0) {
           return commonRespParam;
        } else {
			commonRespParam.setResultCode(Message.FAILURE_CODE);
			commonRespParam.setResultMsg(Message.FAILURE);
			return commonRespParam;
        }
	}
	

}
