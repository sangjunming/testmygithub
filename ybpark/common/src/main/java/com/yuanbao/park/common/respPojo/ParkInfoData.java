package com.yuanbao.park.common.respPojo;

import java.util.Date;

public class ParkInfoData {
	
    private Long id;

    private String name;

    private Long price;

    private String partLabel;

    private String partGeographic;

    private String partRoundTraffic;

    private String photo;

    private String company;

    private Integer area;

    private String facility;

    private String companyId;

    private Integer deleteType;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String partSummary;

    private String partService;

    private String preferentialPolicy;

    private String applicationConditions;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    public String getPartSummary() {
        return partSummary;
    }

    public void setPartSummary(String partSummary) {
        this.partSummary = partSummary;
    }

    public String getPartService() {
        return partService;
    }

    public void setPartService(String partService) {
        this.partService = partService;
    }

    public String getPreferentialPolicy() {
        return preferentialPolicy;
    }

    public void setPreferentialPolicy(String preferentialPolicy) {
        this.preferentialPolicy = preferentialPolicy;
    }

    public String getApplicationConditions() {
        return applicationConditions;
    }

    public void setApplicationConditions(String applicationConditions) {
        this.applicationConditions = applicationConditions;
    }

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPartLabel() {
        return partLabel;
    }

    public void setPartLabel(String partLabel) {
        this.partLabel = partLabel == null ? null : partLabel.trim();
    }

    public String getPartGeographic() {
        return partGeographic;
    }

    public void setPartGeographic(String partGeographic) {
        this.partGeographic = partGeographic == null ? null : partGeographic.trim();
    }

    public String getPartRoundTraffic() {
        return partRoundTraffic;
    }

    public void setPartRoundTraffic(String partRoundTraffic) {
        this.partRoundTraffic = partRoundTraffic == null ? null : partRoundTraffic.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility == null ? null : facility.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
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