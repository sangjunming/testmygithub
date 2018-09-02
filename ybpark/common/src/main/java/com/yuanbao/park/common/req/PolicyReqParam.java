package com.yuanbao.park.common.req;

import java.util.Date;

public class PolicyReqParam extends BasePageReqParam {

    //政策信息id
    private Long id;

    private String title;

    private Date releaseStartTime;

    private Date releaseEndTime;

    //发布单位
    private String issued;

    private String lable;

    private String likeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }
}
