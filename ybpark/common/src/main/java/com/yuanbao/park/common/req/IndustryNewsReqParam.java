package com.yuanbao.park.common.req;

import java.util.Date;

/**
 * @author: CrazyZhou
 * @description: 行业新闻视图层
 * @date: created in 16:27 2018/6/25
 * @param:
 */
public class IndustryNewsReqParam extends BasePageReqParam {

    private String industryName;

    private String likeName;

    private Date releasedStartTime;

    private Date releaseEndTime;

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public Date getReleasedStartTime() {
        return releasedStartTime;
    }

    public void setReleasedStartTime(Date releasedStartTime) {
        this.releasedStartTime = releasedStartTime;
    }

    public Date getReleaseEndTime() {
        return releaseEndTime;
    }

    public void setReleaseEndTime(Date releaseEndTime) {
        this.releaseEndTime = releaseEndTime;
    }
}
