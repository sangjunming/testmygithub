package com.yuanbao.park.common.req;

import java.util.Date;

public class StatisticsReqParam {
    private long parkId;

    private Date year;

    public long getParkId() {
        return parkId;
    }

    public void setParkId(long parkId) {
        this.parkId = parkId;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
}
