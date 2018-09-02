package com.yuanbao.park.common.resp;

import com.yuanbao.park.common.resultUtils.ResultData;

/**
 * @author: CrazyZhou
 * @description:
 * @date: created in 11:00 2018/6/25
 * @param:
 */
public class CommonRespParam<T> extends BaseRespParam {
    private T dataInfo;

    public CommonRespParam() {
    }

    public T getDataInfo() {
        return this.dataInfo;
    }

    public void setDataInfo(T dataInfo) {
        this.dataInfo = dataInfo;
    }
}
