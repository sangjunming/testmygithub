package com.yuanbao.park.common.resultUtils;


import com.yuanbao.park.common.resp.BasePageParam;

/**
 * 接口返回数据格式
 */
public class ResultData {
    private int code;
    private String mesg;
    private Object data=new Object();

    public ResultData() {

    }

    //默认结果
    public static ResultData defaultResult(){
        return new ResultData(MessageEnum.SYSTEM_UNKNOWN_ERROR);
    }
    //不含有业务数据结果集
    public ResultData(MessageEnum mesg) {
        this.code = mesg.getCode();
        this.mesg = mesg.getDesc();
    }

    //含有业务数据结果集
    public ResultData(MessageEnum mesg, Object data) {
        this.code = mesg.getCode();
        this.mesg = mesg.getDesc();
        this.data = data;
    }
    //自定义异常封装
    public ResultData(SystemException e) {
        this.code = e.getMessageEnum().getCode();
        this.mesg = e.getMessageEnum().getDesc();
    }
    //系统异常封装
    public ResultData(Exception e) {
        e.printStackTrace();
        this.code = MessageEnum.SYSTEM_INTERNAL_ERROR.getCode();
        this.mesg ="系统异常";

    }




    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
