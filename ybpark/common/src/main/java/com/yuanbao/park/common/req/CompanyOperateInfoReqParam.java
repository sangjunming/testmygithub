package com.yuanbao.park.common.req;

import java.util.Date;

/**
 * @author: CrazyZhou
 * @description: 企业经营信息视图层实体类
 * @date: 2018-06-29 10:52
 * @param:
 */
public class CompanyOperateInfoReqParam {

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
        this.exportSum = exportSum;
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
        this.businessService = businessService;
    }

    public String getAccountingService() {
        return accountingService;
    }

    public void setAccountingService(String accountingService) {
        this.accountingService = accountingService;
    }

    public String getFinancingService() {
        return financingService;
    }

    public void setFinancingService(String financingService) {
        this.financingService = financingService;
    }

    public String getHrService() {
        return hrService;
    }

    public void setHrService(String hrService) {
        this.hrService = hrService;
    }

    public String getProjectApplicationService() {
        return projectApplicationService;
    }

    public void setProjectApplicationService(String projectApplicationService) {
        this.projectApplicationService = projectApplicationService;
    }

    public String getSmeConsultingService() {
        return smeConsultingService;
    }

    public void setSmeConsultingService(String smeConsultingService) {
        this.smeConsultingService = smeConsultingService;
    }

    public String getPublicTechnologyService() {
        return publicTechnologyService;
    }

    public void setPublicTechnologyService(String publicTechnologyService) {
        this.publicTechnologyService = publicTechnologyService;
    }

    public String getFinanceIntegrationService() {
        return financeIntegrationService;
    }

    public void setFinanceIntegrationService(String financeIntegrationService) {
        this.financeIntegrationService = financeIntegrationService;
    }

    public String getLifeSupportingService() {
        return lifeSupportingService;
    }

    public void setLifeSupportingService(String lifeSupportingService) {
        this.lifeSupportingService = lifeSupportingService;
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
}
