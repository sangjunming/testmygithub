package com.yuanbao.park.common.resp;

import com.yuanbao.park.common.req.BasePageReqParam;
import com.yuanbao.park.common.resultUtils.ResultData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 向页面返回的集合对象
 * @date: created in 10:59 2018/6/25
 * @param:
 */
public class CommonListRespParam<T> extends BaseRespParam {
    private List<T> dataInfos = new ArrayList();
    private BasePageParam basePageParam;

    public CommonListRespParam() {
    }

    public List<T> getDataInfos() {
        return this.dataInfos;
    }

    public void setDataInfos(List<T> dataInfos) {
        this.dataInfos = dataInfos;
    }

    public BasePageParam getBasePageParam() {
        return this.basePageParam;
    }

    public void setBasePageParam(BasePageParam basePageParam) {
        this.basePageParam = basePageParam;
    }

    @Override
    public String toString() {
        return "CommonListRespParam{" +
                "dataInfos=" + dataInfos +
                ", basePageParam=" + basePageParam +
                '}';
    }
}