package com.yuanbao.park.common.req;

import java.util.List;

public class UUserReqParam {
    private String name;
    private String telephone;
    //所属角色为集合形式
    private List roleName;
    private String department;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List getRoleName() {
        return roleName;
    }

    public void setRoleName(List roleName) {
        this.roleName = roleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
