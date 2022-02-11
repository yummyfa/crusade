package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: wangliang
 * @Date: 2021/11/25 9:34
 */
public class Match {
    /**
     * 比赛id
     */
    @ApiModelProperty(value = "比赛id")
    private Integer matchId;

    private String nationOne;

    private String playersOne;

    private String headCoachOne;

    private String nationTwo;

    private String playersTwo;

    private String headCoachTwo;

    private String ninetyMinuteResults;

    private String finallyResults;

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

    public Match(Integer matchId, String nationOne, String playersOne, String headCoachOne, String nationTwo, String playersTwo, String headCoachTwo, String ninetyMinuteResults, String finallyResults, Date createTime, Date updateTime, String createUser, String updateUser, Integer isDel) {
        this.matchId = matchId;
        this.nationOne = nationOne;
        this.playersOne = playersOne;
        this.headCoachOne = headCoachOne;
        this.nationTwo = nationTwo;
        this.playersTwo = playersTwo;
        this.headCoachTwo = headCoachTwo;
        this.ninetyMinuteResults = ninetyMinuteResults;
        this.finallyResults = finallyResults;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.isDel = isDel;
    }

    public Match() {
    }

    public String getHeadCoachTwo() {
        return headCoachTwo;
    }

    public void setHeadCoachTwo(String headCoachTwo) {
        this.headCoachTwo = headCoachTwo;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getNationOne() {
        return nationOne;
    }

    public void setNationOne(String nationOne) {
        this.nationOne = nationOne;
    }

    public String getPlayersOne() {
        return playersOne;
    }

    public void setPlayersOne(String playersOne) {
        this.playersOne = playersOne;
    }

    public String getHeadCoachOne() {
        return headCoachOne;
    }

    public void setHeadCoachOne(String headCoachOne) {
        this.headCoachOne = headCoachOne;
    }

    public String getNationTwo() {
        return nationTwo;
    }

    public void setNationTwo(String nationTwo) {
        this.nationTwo = nationTwo;
    }

    public String getPlayersTwo() {
        return playersTwo;
    }

    public void setPlayersTwo(String playersTwo) {
        this.playersTwo = playersTwo;
    }

    public String getNinetyMinuteResults() {
        return ninetyMinuteResults;
    }

    public void setNinetyMinuteResults(String ninetyMinuteResults) {
        this.ninetyMinuteResults = ninetyMinuteResults;
    }

    public String getFinallyResults() {
        return finallyResults;
    }

    public void setFinallyResults(String finallyResults) {
        this.finallyResults = finallyResults;
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

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", nationOne='" + nationOne + '\'' +
                ", playersOne='" + playersOne + '\'' +
                ", headCoachOne='" + headCoachOne + '\'' +
                ", nationTwo='" + nationTwo + '\'' +
                ", playersTwo='" + playersTwo + '\'' +
                ", ninetyMinuteResults='" + ninetyMinuteResults + '\'' +
                ", finallyResults='" + finallyResults + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
