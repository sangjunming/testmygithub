package com.yuanbao.park.entity;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "company_operate_info")
@NameStyle(Style.normal)
public class CompanyOperateInfo {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Integer years;

    private Long yearlyIncoming;

    private Long netProfit;

    private String exportSum;

    private Long yearlyRDFund;

    private Long companyId;

    private Long taxPayed;

    private Integer nationalRDProject;

    private Long nationalRDFinancing;

    private Integer provinceRDProject;

    private Long provinceRDFinancing;

    private String businessService;

    private String accountingService;

    private String financingService;

    private String hrService;

    private String projectApplicationService;

    private String smeConsultingService;

    private String publicTechnologyService;

    private String financeIntegrationService;

    private String lifeSupportingService;

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

    public Long getYearlyIncoming() {
        return yearlyIncoming;
    }

    public void setYearlyIncoming(Long yearlyIncoming) {
        this.yearlyIncoming = yearlyIncoming;
    }

    public Long getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Long netProfit) {
        this.netProfit = netProfit;
    }

    public String getExportSum() {
        return exportSum;
    }

    public void setExportSum(String exportSum) {
        this.exportSum = exportSum == null ? null : exportSum.trim();
    }

    public Long getYearlyRDFund() {
        return yearlyRDFund;
    }

    public void setYearlyRDFund(Long yearlyRDFund) {
        this.yearlyRDFund = yearlyRDFund;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getTaxPayed() {
        return taxPayed;
    }

    public void setTaxPayed(Long taxPayed) {
        this.taxPayed = taxPayed;
    }

    public Integer getNationalRDProject() {
        return nationalRDProject;
    }

    public void setNationalRDProject(Integer nationalRDProject) {
        this.nationalRDProject = nationalRDProject;
    }

    public Long getNationalRDFinancing() {
        return nationalRDFinancing;
    }

    public void setNationalRDFinancing(Long nationalRDFinancing) {
        this.nationalRDFinancing = nationalRDFinancing;
    }

    public Integer getProvinceRDProject() {
        return provinceRDProject;
    }

    public void setProvinceRDProject(Integer provinceRDProject) {
        this.provinceRDProject = provinceRDProject;
    }

    public Long getProvinceRDFinancing() {
        return provinceRDFinancing;
    }

    public void setProvinceRDFinancing(Long provinceRDFinancing) {
        this.provinceRDFinancing = provinceRDFinancing;
    }

    public String getBusinessService() {
        return businessService;
    }

    public void setBusinessService(String businessService) {
        this.businessService = businessService == null ? null : businessService.trim();
    }

    public String getAccountingService() {
        return accountingService;
    }

    public void setAccountingService(String accountingService) {
        this.accountingService = accountingService == null ? null : accountingService.trim();
    }

    public String getFinancingService() {
        return financingService;
    }

    public void setFinancingService(String financingService) {
        this.financingService = financingService == null ? null : financingService.trim();
    }

    public String getHrService() {
        return hrService;
    }

    public void setHrService(String hrService) {
        this.hrService = hrService == null ? null : hrService.trim();
    }

    public String getProjectApplicationService() {
        return projectApplicationService;
    }

    public void setProjectApplicationService(String projectApplicationService) {
        this.projectApplicationService = projectApplicationService == null ? null : projectApplicationService.trim();
    }

    public String getSmeConsultingService() {
        return smeConsultingService;
    }

    public void setSmeConsultingService(String smeConsultingService) {
        this.smeConsultingService = smeConsultingService == null ? null : smeConsultingService.trim();
    }

    public String getPublicTechnologyService() {
        return publicTechnologyService;
    }

    public void setPublicTechnologyService(String publicTechnologyService) {
        this.publicTechnologyService = publicTechnologyService == null ? null : publicTechnologyService.trim();
    }

    public String getFinanceIntegrationService() {
        return financeIntegrationService;
    }

    public void setFinanceIntegrationService(String financeIntegrationService) {
        this.financeIntegrationService = financeIntegrationService == null ? null : financeIntegrationService.trim();
    }

    public String getLifeSupportingService() {
        return lifeSupportingService;
    }

    public void setLifeSupportingService(String lifeSupportingService) {
        this.lifeSupportingService = lifeSupportingService == null ? null : lifeSupportingService.trim();
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