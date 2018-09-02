package com.yuanbao.park.common.respPojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StatisticsInfoData {
    private Long id;

    private Long parkId;

    private Date years;

    private Long companyNum;

    private Long incubator;

    private Long college;

    private Double totalRevenue;

    private Double tax;

    private Double investigativeRate;

    private Integer nationalProject;

    private Integer nationalProjectfunding;

    private Integer provincialProject;

    private Integer provincialProjectFunding;

    private Integer intellectualProperty;

    private Integer softwareCopyright;

    private Integer patent;

    private Integer inventionPatent;

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

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getYears() {
        return years;
    }

    public void setYears(Date years) {
        this.years = years;
    }

    public Long getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(Long companyNum) {
        this.companyNum = companyNum;
    }

    public Long getIncubator() {
        return incubator;
    }

    public void setIncubator(Long incubator) {
        this.incubator = incubator;
    }

    public Long getCollege() {
        return college;
    }

    public void setCollege(Long college) {
        this.college = college;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getInvestigativeRate() {
        return investigativeRate;
    }

    public void setInvestigativeRate(Double investigativeRate) {
        this.investigativeRate = investigativeRate;
    }

    public Integer getNationalProject() {
        return nationalProject;
    }

    public void setNationalProject(Integer nationalProject) {
        this.nationalProject = nationalProject;
    }

    public Integer getNationalProjectfunding() {
        return nationalProjectfunding;
    }

    public void setNationalProjectfunding(Integer nationalProjectfunding) {
        this.nationalProjectfunding = nationalProjectfunding;
    }

    public Integer getProvincialProject() {
        return provincialProject;
    }

    public void setProvincialProject(Integer provincialProject) {
        this.provincialProject = provincialProject;
    }

    public Integer getProvincialProjectFunding() {
        return provincialProjectFunding;
    }

    public void setProvincialProjectFunding(Integer provincialProjectFunding) {
        this.provincialProjectFunding = provincialProjectFunding;
    }

    public Integer getIntellectualProperty() {
        return intellectualProperty;
    }

    public void setIntellectualProperty(Integer intellectualProperty) {
        this.intellectualProperty = intellectualProperty;
    }

    public Integer getSoftwareCopyright() {
        return softwareCopyright;
    }

    public void setSoftwareCopyright(Integer softwareCopyright) {
        this.softwareCopyright = softwareCopyright;
    }

    public Integer getPatent() {
        return patent;
    }

    public void setPatent(Integer patent) {
        this.patent = patent;
    }

    public Integer getInventionPatent() {
        return inventionPatent;
    }

    public void setInventionPatent(Integer inventionPatent) {
        this.inventionPatent = inventionPatent;
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
