package com.yuanbao.park.entity;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cooperation_method")
@NameStyle(Style.normal)
public class CooperationMethod {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String cooMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCooMethod() {
        return cooMethod;
    }

    public void setCooMethod(String cooMethod) {
        this.cooMethod = cooMethod == null ? null : cooMethod.trim();
    }
}