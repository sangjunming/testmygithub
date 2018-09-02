package com.yuanbao.park.entity;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "statistics")
@NameStyle(Style.normal)
public class Statistics {
	@Id
    @GeneratedValue(generator = "JDBC")
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

    private Double nationalProjectFunding;

    private Integer provincialProject;

    private Double provincialProjectFunding;

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



    public Integer getProvincialProject() {
        return provincialProject;
    }

    public void setProvincialProject(Integer provincialProject) {
        this.provincialProject = provincialProject;
    }

    public Double getNationalProjectFunding() {
        return nationalProjectFunding;
    }

    public void setNationalProjectFunding(Double nationalProjectFunding) {
        this.nationalProjectFunding = nationalProjectFunding;
    }

    public Double getProvincialProjectFunding() {
        return provincialProjectFunding;
    }

    public void setProvincialProjectFunding(Double provincialProjectFunding) {
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
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }
}