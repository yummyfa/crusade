package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: wangliang
 * @Date: 2021/11/25 10:24
 */
public class WarInfo {

    private Integer warId;

    @ApiModelProperty(value = "比赛名称")
    private String name;

    @ApiModelProperty(value = "举办时间")
    private String holdTime;

    @ApiModelProperty(value = "举办国")
    private String holdCountry;

    @ApiModelProperty(value = "举办大陆")
    private String continent;

    @ApiModelProperty(value = "持续时间")
    private String duration;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "更新人")
    private String updateUser;

    @ApiModelProperty(value = "是否删除 0 normal ，1 deleted")
    private Integer isDel;

    public WarInfo(Integer warId, String name, String holdTime, String holdCountry, String continent, String duration, Date createTime, Date updateTime, String createUser, String updateUser, Integer isDel) {
        this.warId = warId;
        this.name = name;
        this.holdTime = holdTime;
        this.holdCountry = holdCountry;
        this.continent = continent;
        this.duration = duration;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.isDel = isDel;
    }

    public WarInfo() {
    }

    public Integer getWarId() {
        return warId;
    }

    public void setWarId(Integer warId) {
        this.warId = warId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(String holdTime) {
        this.holdTime = holdTime;
    }

    public String getHoldCountry() {
        return holdCountry;
    }

    public void setHoldCountry(String holdCountry) {
        this.holdCountry = holdCountry;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}

