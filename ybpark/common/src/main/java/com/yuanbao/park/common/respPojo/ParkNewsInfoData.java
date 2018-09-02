package com.yuanbao.park.common.respPojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ParkNewsInfoData {
    private Long id;

    private Long labelId;

    private String companyName;

    private Long companyId;

    private String title;

    private String source;

    private String spiderSource;

    private String sourceWebsite;

    private String tag;

    private Date releasedTime;

    private Integer deleteType;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String content;

    /*搜索关键字*/
    private String likeName;

    /*发布时间搜索的开始时间*/
    private Date releaseStartTime;

    /*发布时间搜索的结束时间*/
    private Date releaseEndTime;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSpiderSource() {
        return spiderSource;
    }

    public void setSpiderSource(String spiderSource) {
        this.spiderSource = spiderSource;
    }

    public String getSourceWebsite() {
        return sourceWebsite;
    }

    public void setSourceWebsite(String sourceWebsite) {
        this.sourceWebsite = sourceWebsite;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
