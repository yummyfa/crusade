package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: wangliang
 * @Date: 2021/12/7 14:17
 */
public class Predict {


    private Integer id;

    @ApiModelProperty(value = "胜")
    private Double winRate;

    @ApiModelProperty(value = "败")
    private Double loseRate;

    @ApiModelProperty(value = "平")
    private Double drawRate;

    @ApiModelProperty(value = "比赛")
    private Integer matchId;

    @ApiModelProperty(value = "一队")
    private String teamOne;

    @ApiModelProperty(value = "二队")
    private String teamTwo;

    @ApiModelProperty(value = "支持")
    private String support;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "是否删除")
    private Integer isDel;

    public Predict(Integer id, Double winRate, Double loseRate, Double drawRate, Integer matchId, String teamOne, String teamTwo, String support, Date createTime, Integer isDel) {
        this.id = id;
        this.winRate = winRate;
        this.loseRate = loseRate;
        this.drawRate = drawRate;
        this.matchId = matchId;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.support = support;
        this.createTime = createTime;
        this.isDel = isDel;
    }

    public Predict() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getWinRate() {
        return winRate;
    }

    public void setWinRate(Double winRate) {
        this.winRate = winRate;
    }

    public Double getLoseRate() {
        return loseRate;
    }

    public void setLoseRate(Double loseRate) {
        this.loseRate = loseRate;
    }

    public Double getDrawRate() {
        return drawRate;
    }

    public void setDrawRate(Double drawRate) {
        this.drawRate = drawRate;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
