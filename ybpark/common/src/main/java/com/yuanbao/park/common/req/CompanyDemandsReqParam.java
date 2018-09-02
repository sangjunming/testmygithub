package com.yuanbao.park.common.req;

import java.util.Date;

/**
 * @author: CrazyZhou
 * @description: 企业需求视图层实体类
 * @date: 2018-07-08 15:27
 * @param:
 */
public class CompanyDemandsReqParam {
    private Long id;

    private Long companyId;

    private String demandsName;

    private String demandsContent;

    private Integer deleteType;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getDemandsName() {
        return demandsName;
    }

    public void setDemandsName(String demandsName) {
        this.demandsName = demandsName;
    }

    public String getDemandsContent() {
        return demandsContent;
    }

    public void setDemandsContent(String demandsContent) {
        this.demandsContent = demandsContent;
    }

    public Integer getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(Integer deleteType) {
        this.deleteType = deleteType;
    }
}
