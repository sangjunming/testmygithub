package com.yuanbao.park.common.resp;
/**
 * @Author: CrazyZhou
 * @Description: 返回页面分页结果
 * @Date: created in 10:59 2018/6/25
 * @param:
 */
public class BasePageParam {
    private Integer curPage;
    private Integer totalPage;
    private Long totalSize;
    private Integer pageSize;

    public BasePageParam() {
    }

    public Integer getCurPage() {
        return this.curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalSize() {
        return this.totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return "BasePageParam{curPage=" + this.curPage + ", totalPage=" + this.totalPage + ", totalSize=" + this.totalSize + ", pageSize=" + this.pageSize + '}';
    }
}
