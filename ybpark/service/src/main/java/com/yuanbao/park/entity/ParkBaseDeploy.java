package com.yuanbao.park.entity;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "park_base_deploy")
@NameStyle(Style.normal)
public class ParkBaseDeploy {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long parkId;

    private String talentedPersonPlan;

    private String parkLabel;

    private String simpleParkAddress;

    private String parkDetailedAddress;

    private String attentionIndustry;

    private String enterStationStatusName;

    private String companyMaterialName;

    private String serverAgencyName;

    private String serverName;

    private Integer deployType;

    private Integer deleteType;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    private String remark1;

    private String remark2;

    private String remark3;

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

    public String getTalentedPersonPlan() {
        return talentedPersonPlan;
    }

    public void setTalentedPersonPlan(String talentedPersonPlan) {
        this.talentedPersonPlan = talentedPersonPlan == null ? null : talentedPersonPlan.trim();
    }

    public String getParkLabel() {
        return parkLabel;
    }

    public void setParkLabel(String parkLabel) {
        this.parkLabel = parkLabel == null ? null : parkLabel.trim();
    }

    public String getSimpleParkAddress() {
        return simpleParkAddress;
    }

    public void setSimpleParkAddress(String simpleParkAddress) {
        this.simpleParkAddress = simpleParkAddress == null ? null : simpleParkAddress.trim();
    }

    public String getParkDetailedAddress() {
        return parkDetailedAddress;
    }

    public void setParkDetailedAddress(String parkDetailedAddress) {
        this.parkDetailedAddress = parkDetailedAddress == null ? null : parkDetailedAddress.trim();
    }

    public String getAttentionIndustry() {
        return attentionIndustry;
    }

    public void setAttentionIndustry(String attentionIndustry) {
        this.attentionIndustry = attentionIndustry == null ? null : attentionIndustry.trim();
    }

    public String getEnterStationStatusName() {
        return enterStationStatusName;
    }

    public void setEnterStationStatusName(String enterStationStatusName) {
        this.enterStationStatusName = enterStationStatusName;
    }

    public String getCompanyMaterialName() {
        return companyMaterialName;
    }

    public void setCompanyMaterialName(String companyMaterialName) {
        this.companyMaterialName = companyMaterialName;
    }

    public String getServerAgencyName() {
        return serverAgencyName;
    }

    public void setServerAgencyName(String serverAgencyName) {
        this.serverAgencyName = serverAgencyName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Integer getDeployType() {
        return deployType;
    }

    public void setDeployType(Integer deployType) {
        this.deployType = deployType;
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
}