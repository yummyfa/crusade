package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Company)实体类
 *
 * @author makejava
 * @since 2021-11-13 14:19:52
 */
public class Company implements Serializable {
    private static final long serialVersionUID = 230279313467501472L;
    /**
     * 公司id
     */
    @ApiModelProperty(value = "公司id")
    private Integer companyId;
    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司id")
    private String companyName;
    /**
     * 公司图标
     */
    @ApiModelProperty(value = "公司图标")
    private String companyIcon;
    /**
     * 公司详细信息
     */
    @ApiModelProperty(value = "公司详细信息")
    private String companyInfo;

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

    public Company(Integer companyId, String companyName, String companyIcon, String companyInfo, Date createTime, Date updateTime, String createUser, String updateUser, Integer isDel) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyIcon = companyIcon;
        this.companyInfo = companyInfo;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.isDel = isDel;
    }

    public Company() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyIcon() {
        return companyIcon;
    }

    public void setCompanyIcon(String companyIcon) {
        this.companyIcon = companyIcon;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
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

