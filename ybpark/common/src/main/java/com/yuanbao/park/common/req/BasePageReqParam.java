package com.yuanbao.park.common.req;
/**
 * @Author: CrazyZhou
 * @Description: 接收页面的分页参数
 * @Date: created in 10:59 2018/6/25
 * @param:
 */
public class BasePageReqParam {
    private Integer pageIndex = 1;
    private Integer startIndex;
    private Integer pageSize = 20;

    public BasePageReqParam() {
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return "BasePageReqParam{pageIndex=" + this.pageIndex + ", startIndex=" + this.startIndex + ", pageSize=" + this.pageSize + '}';
    }
}
