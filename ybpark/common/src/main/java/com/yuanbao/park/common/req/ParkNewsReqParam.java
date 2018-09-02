package com.yuanbao.park.common.req;

import java.util.Date;

public class ParkNewsReqParam extends BasePageReqParam{
    private Long id;

    private Long labelId;

    private String labelName;

    private Integer labelType;

    //新闻标题即是新闻名
    private String title;

    private String parkName;

    private Long parkId;

    private String sources;

    private String sourcesWebsite;

    private String tag;

    private String content;

    private Date releasedTime;

    private Integer deleteType;

    private Integer newsType;

    private String publicationUnit;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String remark1;

    private String remark2;

    private String remark3;

    /*搜索关键字*/
    private String likeName;

    /*发布时间搜索的开始时间*/
    private Date releaseStartTime;

    /*发布时间搜索的结束时间*/
    private Date releaseEndTime;

    public Integer getLabelType() {
        return labelType;
    }

    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getPublicationUnit() {
        return publicationUnit;
    }

    public void setPublicationUnit(String publicationUnit) {
        this.publicationUnit = publicationUnit;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getSourcesWebsite() {
        return sourcesWebsite;
    }

    public void setSourcesWebsite(String sourcesWebsite) {
        this.sourcesWebsite = sourcesWebsite;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleasedTime() {
        return releasedTime;
    }

    public void setReleasedTime(Date releasedTime) {
        this.releasedTime = releasedTime;
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

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public Date getReleaseStartTime() {
        return releaseStartTime;
    }

    public void setReleaseStartTime(Date releaseStartTime) {
        this.releaseStartTime = releaseStartTime;
    }

    public Date getReleaseEndTime() {
        return releaseEndTime;
    }

    public void setReleaseEndTime(Date releaseEndTime) {
        this.releaseEndTime = releaseEndTime;
    }
}
