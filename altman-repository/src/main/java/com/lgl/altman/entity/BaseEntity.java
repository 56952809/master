package com.lgl.altman.entity;

import javax.persistence.Column;

public class BaseEntity {
    @Column(nullable = false)
    private String createTime;
    @Column(nullable = false)
    private String updateTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
