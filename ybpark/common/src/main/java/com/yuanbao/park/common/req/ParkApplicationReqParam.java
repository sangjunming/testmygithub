package com.yuanbao.park.common.req;

import java.util.Date;

public class ParkApplicationReqParam extends BasePageReqParam {
	private  long parkId;
	private  String companyName;
	private  Date startDate;
	private  Date endDate;
	private  String companyContacts;
	private  String telephone;
	private  Integer applicationType;

	public long getParkId() {
		return parkId;
	}
	public void setParkId(long parkId) {
		this.parkId = parkId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCompanyContacts() {
		return companyContacts;
	}
	public void setCompanyContacts(String companyContacts) {
		this.companyContacts = companyContacts;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(Integer applicationType) {
		this.applicationType = applicationType;
	}


}
