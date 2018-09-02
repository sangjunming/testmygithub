package com.yuanbao.park.entity;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "park_application")
@NameStyle(Style.normal)
public class PartApplication {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String name;

    private String telephone;

    private Date applicationDate;

    private Integer applicationType;

    private Integer printNum;

    private Integer deleteType;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String parkId;

    private Date registerTime;

    private String supportAndServer;

    private String applicationCompanyName;

    private String alternativeBusinessFontSize;

    private String companyPlace;

    private Long registeredCapital;

    private String companyType;

    private String projectDescription;

    private String teamComposition;

    private Long investmentAmount;

    private String itemName;

    private String industryCategory;

    private String domesticIndustryAnalysis;

    private Integer policySupport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Integer applicationType) {
        this.applicationType = applicationType;
    }

    public Integer getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
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

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId == null ? null : parkId.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getSupportAndServer() {
        return supportAndServer;
    }

    public void setSupportAndServer(String supportAndServer) {
        this.supportAndServer = supportAndServer == null ? null : supportAndServer.trim();
    }

    public String getApplicationCompanyName() {
        return applicationCompanyName;
    }

    public void setApplicationCompanyName(String applicationCompanyName) {
        this.applicationCompanyName = applicationCompanyName == null ? null : applicationCompanyName.trim();
    }

    public String getAlternativeBusinessFontSize() {
        return alternativeBusinessFontSize;
    }

    public void setAlternativeBusinessFontSize(String alternativeBusinessFontSize) {
        this.alternativeBusinessFontSize = alternativeBusinessFontSize == null ? null : alternativeBusinessFontSize.trim();
    }

    public String getCompanyPlace() {
        return companyPlace;
    }

    public void setCompanyPlace(String companyPlace) {
        this.companyPlace = companyPlace == null ? null : companyPlace.trim();
    }

    public Long getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Long registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    public String getTeamComposition() {
        return teamComposition;
    }

    public void setTeamComposition(String teamComposition) {
        this.teamComposition = teamComposition == null ? null : teamComposition.trim();
    }

    public Long getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Long investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory == null ? null : industryCategory.trim();
    }

    public String getDomesticIndustryAnalysis() {
        return domesticIndustryAnalysis;
    }

    public void setDomesticIndustryAnalysis(String domesticIndustryAnalysis) {
        this.domesticIndustryAnalysis = domesticIndustryAnalysis == null ? null : domesticIndustryAnalysis.trim();
    }

    public Integer getPolicySupport() {
        return policySupport;
    }

    public void setPolicySupport(Integer policySupport) {
        this.policySupport = policySupport;
    }
}