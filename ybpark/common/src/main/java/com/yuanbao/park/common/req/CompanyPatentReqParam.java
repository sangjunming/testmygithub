package com.yuanbao.park.common.req;

import java.util.Date;

/**
 * @author: CrazyZhou
 * @description: 企业专利信息视图层实体类
 * @date: 2018-06-27 09:17
 * @param:
 */
public class CompanyPatentReqParam {
    private Long id;

    private Integer years;

    private Integer proprietary;

    private Integer invention;

    private Integer utility;

    private Integer appearance;

    private Integer PCT;

    private Integer trademark;

    private Integer copyright;

    private Integer ic;

    private Integer software;

    private Long companyId;

    private Integer deleteType;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getProprietary() {
        return proprietary;
    }

    public void setProprietary(Integer proprietary) {
        this.proprietary = proprietary;
    }

    public Integer getInvention() {
        return invention;
    }

    public void setInvention(Integer invention) {
        this.invention = invention;
    }

    public Integer getUtility() {
        return utility;
    }

    public void setUtility(Integer utility) {
        this.utility = utility;
    }

    public Integer getAppearance() {
        return appearance;
    }

    public void setAppearance(Integer appearance) {
        this.appearance = appearance;
    }

    public Integer getPCT() {
        return PCT;
    }

    public void setPCT(Integer PCT) {
        this.PCT = PCT;
    }

    public Integer getTrademark() {
        return trademark;
    }

    public void setTrademark(Integer trademark) {
        this.trademark = trademark;
    }

    public Integer getCopyright() {
        return copyright;
    }

    public void setCopyright(Integer copyright) {
        this.copyright = copyright;
    }

    public Integer getIc() {
        return ic;
    }

    public void setIc(Integer ic) {
        this.ic = ic;
    }

    public Integer getSoftware() {
        return software;
    }

    public void setSoftware(Integer software) {
        this.software = software;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(Integer deleteType) {
        this.deleteType = deleteType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
}
