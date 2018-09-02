package com.yuanbao.park.common.resp;

import com.yuanbao.park.common.resultUtils.Message;

/**
 * @author: CrazyZhou
 * @description: 通用的返回消息类
 * @date: 2018-07-04 10:15
 * @param:
 */
public class BaseRespParam {
    private String resultCode = Message.SUCCESS_CODE;
    private String resultMsg = Message.SUCCESS;

    public BaseRespParam() {
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String toString() {
        return "BaseRespParam{resultCode='" + this.resultCode + '\'' + ", resultMsg='" + this.resultMsg + '\'' + '}';
    }
}