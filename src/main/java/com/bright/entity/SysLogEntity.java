package com.bright.entity;

public class SysLogEntity extends BaseEntity {

    private Integer id;
    private String appId;
    private String serverName;
    private String reqPath;
    private String reqParams;
    private String reqType;
    private Integer isSuccess;
    private Long startTime;
    private Long endTime;
    private String userNick;
    private String reqDesc;
    private String ipAddress;

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

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "SysLogEntity{" +
                "id=" + id +
                ", appId='" + appId + '\'' +
                ", serverName='" + serverName + '\'' +
                ", reqPath='" + reqPath + '\'' +
                ", reqParams='" + reqParams + '\'' +
                ", reqType='" + reqType + '\'' +
                ", isSuccess=" + isSuccess +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userNick='" + userNick + '\'' +
                ", reqDesc='" + reqDesc + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
