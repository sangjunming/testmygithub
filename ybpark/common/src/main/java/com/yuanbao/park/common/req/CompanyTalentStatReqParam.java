package com.yuanbao.park.common.req;

import java.util.Date;

/**
 * @author: CrazyZhou
 * @description: 企业人才统计视图层实体类
 * @date: 2018-06-29 11:15
 * @param:
 */
public class CompanyTalentStatReqParam {
    private Long id;

    private Integer years;

    private Integer total;

    private Integer rd;

    private Integer science;

    private Integer doctor;

    private Integer master;

    private Integer postgraduate;

    private Integer bachelor;

    private Integer overseas;

    private Integer college;

    private Integer secondary;

    private Integer internship;

    private Integer freshGraduate;

    private Integer thousandPlan;

    private Integer hundredPlan;

    private Long companyId;

    private Integer cityPartner;

    private Integer deleteType;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRd() {
        return rd;
    }

    public void setRd(Integer rd) {
        this.rd = rd;
    }

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public Integer getPostgraduate() {
        return postgraduate;
    }

    public void setPostgraduate(Integer postgraduate) {
        this.postgraduate = postgraduate;
    }

    public Integer getBachelor() {
        return bachelor;
    }

    public void setBachelor(Integer bachelor) {
        this.bachelor = bachelor;
    }

    public Integer getOverseas() {
        return overseas;
    }

    public void setOverseas(Integer overseas) {
        this.overseas = overseas;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public Integer getSecondary() {
        return secondary;
    }

    public void setSecondary(Integer secondary) {
        this.secondary = secondary;
    }

    public Integer getInternship() {
        return internship;
    }

    public void setInternship(Integer internship) {
        this.internship = internship;
    }

    public Integer getFreshGraduate() {
        return freshGraduate;
    }

    public void setFreshGraduate(Integer freshGraduate) {
        this.freshGraduate = freshGraduate;
    }

    public Integer getThousandPlan() {
        return thousandPlan;
    }

    public void setThousandPlan(Integer thousandPlan) {
        this.thousandPlan = thousandPlan;
    }

    public Integer getHundredPlan() {
        return hundredPlan;
    }

    public void setHundredPlan(Integer hundredPlan) {
        this.hundredPlan = hundredPlan;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getCityPartner() {
        return cityPartner;
    }

    public void setCityPartner(Integer cityPartner) {
        this.cityPartner = cityPartner;
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
}
