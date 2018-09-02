package com.yuanbao.park.common.req;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: CrazyZhou
 * @description: 企业基本信息视图层实体类
 * @date: 2018-06-27 11:38
 * @param:
 */
public class CompanyBasicInfoReqParam extends BasePageReqParam {

    //公司基本信息属性
    private Long id;

    private String roundNum;

    private String companyName;

    private String businese;

    private String qualifications;

    private Integer category;

    private Date entryTime;

    private Integer entryState;

    private String contact;

    private String contactNumber;

    private String teamSize;

    private String address;

    private String graphs;

    private String commentMessage;

    private String logo;

    private String socialCreditCode;

    private BigDecimal registeredCapital;

    private String legalRepresentative;

    private Date establishmentDate;

    private Date approvalDate;

    private Integer operationStatus;

    private Date operationTermStart;

    private Date operationTermEnd;

    private String registerInstitution;

    private Integer companyType;

    private String operationRange;

    private String registrationAddress;

    private Date createTime;

    private Date updateTime;

    private Integer deleteType;

    private Date deleteTime;

    private Long parkId;

    private String website;

    private Long companyId;

    //公司股东相关属性
    private String name;

    private Double holdingRate;

    private String investmentAmount;

    private Integer partnerType;

    //公司员工相关属性
    private Long employeeId;

    private String employeeName;

    private String position;

    /*搜索企业信息时最小注册资本与最大注册资本*/
    private BigDecimal registerMinCapital;

    private BigDecimal registerMaxCapital;

    /*搜索企业信息时搜索注册日期的开始日期与结束日期*/
    private Date registerStartTime;

    private Date registerEndTime;

    /*搜索企业信息的入园开始时间与结束时间字段*/
    private Date entryStartTime;

    private Date entryEndTime;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getEntryStartTime() {
        return entryStartTime;
    }

    public void setEntryStartTime(Date entryStartTime) {
        this.entryStartTime = entryStartTime;
    }

    public Date getEntryEndTime() {
        return entryEndTime;
    }

    public void setEntryEndTime(Date entryEndTime) {
        this.entryEndTime = entryEndTime;
    }

    public Date getRegisterStartTime() {
        return registerStartTime;
    }

    public void setRegisterStartTime(Date registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    public Date getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(Date registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public BigDecimal getRegisterMinCapital() {
        return registerMinCapital;
    }

    public void setRegisterMinCapital(BigDecimal registerMinCapital) {
        this.registerMinCapital = registerMinCapital;
    }

    public BigDecimal getRegisterMaxCapital() {
        return registerMaxCapital;
    }

    public void setRegisterMaxCapital(BigDecimal registerMaxCapital) {
        this.registerMaxCapital = registerMaxCapital;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(String roundNum) {
        this.roundNum = roundNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinese() {
        return businese;
    }

    public void setBusinese(String businese) {
        this.businese = businese;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getEntryState() {
        return entryState;
    }

    public void setEntryState(Integer entryState) {
        this.entryState = entryState;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGraphs() {
        return graphs;
    }

    public void setGraphs(String graphs) {
        this.graphs = graphs;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSocialCreditCode() {
        return socialCreditCode;
    }

    public void setSocialCreditCode(String socialCreditCode) {
        this.socialCreditCode = socialCreditCode;
    }

    public BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Integer getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(Integer operationStatus) {
        this.operationStatus = operationStatus;
    }

    public Date getOperationTermStart() {
        return operationTermStart;
    }

    public void setOperationTermStart(Date operationTermStart) {
        this.operationTermStart = operationTermStart;
    }

    public Date getOperationTermEnd() {
        return operationTermEnd;
    }

    public void setOperationTermEnd(Date operationTermEnd) {
        this.operationTermEnd = operationTermEnd;
    }

    public String getRegisterInstitution() {
        return registerInstitution;
    }

    public void setRegisterInstitution(String registerInstitution) {
        this.registerInstitution = registerInstitution;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getOperationRange() {
        return operationRange;
    }

    public void setOperationRange(String operationRange) {
        this.operationRange = operationRange;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
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

    public Integer getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(Integer deleteType) {
        this.deleteType = deleteType;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHoldingRate() {
        return holdingRate;
    }

    public void setHoldingRate(Double holdingRate) {
        this.holdingRate = holdingRate;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Integer getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Integer partnerType) {
        this.partnerType = partnerType;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
