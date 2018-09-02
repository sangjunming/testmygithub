package com.yuanbao.park.common.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.yuanbao.park.common.resp.BasePageParam;

import java.util.List;

/**
 * @author: CrazyZhou
 * @description: 分页工具类
 * @date: created in 17:25 2018/6/25
 * @param:
 */
public class BasePageRespParamsUtils {
    public BasePageRespParamsUtils() {
    }

    public static BasePageParam buildBasePageParam(List list) {
        if (null == list) {
            return new BasePageParam();
        } else {
            PageInfo pageInfo = new PageInfo(list);
            BasePageParam basePageParam = new BasePageParam();
            basePageParam.setTotalPage(pageInfo.getPages());
            basePageParam.setTotalSize(pageInfo.getTotal());
            basePageParam.setCurPage(pageInfo.getPageNum());
            basePageParam.setPageSize(pageInfo.getPageSize());
            return basePageParam;
        }
    }

    public static BasePageParam buildBasePageParam(Page page) {
        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setTotalPage(page.getPages());
        basePageParam.setTotalSize(page.getTotal());
        basePageParam.setCurPage(page.getPageNum());
        basePageParam.setPageSize(page.getPageSize());
        return basePageParam;
    }
}
