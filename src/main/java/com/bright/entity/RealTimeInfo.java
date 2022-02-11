package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: wangliang
 * @Date: 2021/11/25 10:10
 */
public class RealTimeInfo {

    private Integer id;

    /**
     * 是否让
     */
    @ApiModelProperty(value = "是否让 0 不让 ，1 让")
    private Integer isConcede;

    /**
     * 让个数
     */
    @ApiModelProperty(value = "让个数")
    private Integer concedeCount;

    @ApiModelProperty(value = "公司id")
    private Integer companyId;

    @ApiModelProperty(value = "胜率")
    private String winOdds;

    @ApiModelProperty(value = "败率")
    private String loseOdds;

    @ApiModelProperty(value = "平率")
    private String drawOdds;

    @ApiModelProperty(value = "比赛id")
    private Integer matchId;

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

    public RealTimeInfo(Integer id, Integer isConcede, Integer concedeCount, Integer companyId, String winOdds, String loseOdds, String drawOdds, Integer matchId, Date createTime, Date updateTime, String createUser, String updateUser, Integer isDel) {
        this.id = id;
        this.isConcede = isConcede;
        this.concedeCount = concedeCount;
        this.companyId = companyId;
        this.winOdds = winOdds;
        this.loseOdds = loseOdds;
        this.drawOdds = drawOdds;
        this.matchId = matchId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.isDel = isDel;
    }

    public RealTimeInfo() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsConcede() {
        return isConcede;
    }

    public void setIsConcede(Integer isConcede) {
        this.isConcede = isConcede;
    }

    public Integer getConcedeCount() {
        return concedeCount;
    }

    public void setConcedeCount(Integer concedeCount) {
        this.concedeCount = concedeCount;
    }

    public String getWinOdds() {
        return winOdds;
    }

    public void setWinOdds(String winOdds) {
        this.winOdds = winOdds;
    }

    public String getLoseOdds() {
        return loseOdds;
    }

    public void setLoseOdds(String loseOdds) {
        this.loseOdds = loseOdds;
    }

    public String getDrawOdds() {
        return drawOdds;
    }

    public void setDrawOdds(String drawOdds) {
        this.drawOdds = drawOdds;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
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
