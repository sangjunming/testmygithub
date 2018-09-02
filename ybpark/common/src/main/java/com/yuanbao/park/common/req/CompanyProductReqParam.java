package com.yuanbao.park.common.req;

import java.util.Date;

/**
 * @author: CrazyZhou
 * @description: 企业产品信息
 * @date: 2018-06-26 09:33
 * @param:
 */
public class CompanyProductReqParam extends BasePageReqParam {

    //园区ID
    private Long parkId;

    //产品名称
    private String productName;

    //所属行业
    private String industry;

    //企业名称
    private String companyName;

    //融资情况
    private String roundNum;

    //入驻时间搜索的开始时间
    private Date entryStartDate;

    //入驻时间搜索的结束时间
    private Date entryEndDate;

    private Long companyId;

    private String introduction;

    private String advantage;

    private String award;

    private String website;

    private String photo;

    private String video;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(String roundNum) {
        this.roundNum = roundNum;
    }

    public Date getEntryStartDate() {
        return entryStartDate;
    }

    public void setEntryStartDate(Date entryStartDate) {
        this.entryStartDate = entryStartDate;
    }

    public Date getEntryEndDate() {
        return entryEndDate;
    }

    public void setEntryEndDate(Date entryEndDate) {
        this.entryEndDate = entryEndDate;
    }
}
