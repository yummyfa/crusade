package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: wangliang
 * @Date: 2021/11/25 10:28
 */
public class SystemLog {

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "服务名称")
    private String serverName;

    @ApiModelProperty(value = "请求路径")
    private String reqPath;

    @ApiModelProperty(value = "请求参数")
    private String reqParams;

    @ApiModelProperty(value = "请求类型")
    private String reqType;

    @ApiModelProperty(value = "请求开始时间")
    private String startTime;

    @ApiModelProperty(value = "请求结束时间")
    private String endTime;

    @ApiModelProperty(value = "是否成功 0 失败，1成功")
    private Integer isSuccess;

    @ApiModelProperty(value = "请求描述")
    private String reqDesc;

    @ApiModelProperty(value = "请求ip地址")
    private String ipAddress;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人")
    private String createUser;

    @ApiModelProperty(value = "昵称")
    private String userNick;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新人")
    private String updateUser;

    @ApiModelProperty(value = "是否删除 0 normal ，1 deleted")
    private Integer isDel;

    public SystemLog(Integer id, String appId, String serverName, String reqPath, String reqParams, String reqType, String startTime, String endTime, Integer isSuccess, String reqDesc, String ipAddress, Date createTime, String createUser, String userNick, Date updateTime, String updateUser, Integer isDel) {
        this.id = id;
        this.appId = appId;
        this.serverName = serverName;
        this.reqPath = reqPath;
        this.reqParams = reqParams;
        this.reqType = reqType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isSuccess = isSuccess;
        this.reqDesc = reqDesc;
        this.ipAddress = ipAddress;
        this.createTime = createTime;
        this.createUser = createUser;
        this.userNick = userNick;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.isDel = isDel;
    }

    public SystemLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getReqPath() {
        return reqPath;
    }

    public void setReqPath(String reqPath) {
        this.reqPath = reqPath;
    }

    public String getReqParams() {
        return reqParams;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getReqDesc() {
        return reqDesc;
    }

    public void setReqDesc(String reqDesc) {
        this.reqDesc = reqDesc;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
