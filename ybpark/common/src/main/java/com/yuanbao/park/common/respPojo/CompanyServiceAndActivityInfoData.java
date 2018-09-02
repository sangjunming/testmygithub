package com.yuanbao.park.common.respPojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CompanyServiceAndActivityInfoData {
    
	private Long id;

    private Long parkId;

    private Long companyId;
    
    private String companyName;

    private String serviceName;

    private String serviceType;
    
    private String serviceActivityIntroduction;

    private String client;

    private Date serverTime;

    private Integer deleteType;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String location;

    private String annex;

	public String getServiceActivityIntroduction() {
		return serviceActivityIntroduction;
	}

	public void setServiceActivityIntroduction(String serviceActivityIntroduction) {
		this.serviceActivityIntroduction = serviceActivityIntroduction;
	}

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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
	@JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
	public Date getServerTime() {
		return serverTime;
	}
	
	public void setServerTime(Date serverTime) {
		this.serverTime = serverTime;
	}

	public Integer getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(Integer deleteType) {
		this.deleteType = deleteType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAnnex() {
		return annex;
	}

	public void setAnnex(String annex) {
		this.annex = annex;
	}
    

   
}