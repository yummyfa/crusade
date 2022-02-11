package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: wangliang
 * @Date: 2021/11/25 9:42
 */
public class MatchCondition {

    private Integer id;

    @ApiModelProperty(value = "比赛id")
    private Integer matchId;

    /**
     * 条件id
     */
    @ApiModelProperty(value = "条件id")
    private Integer conditionId;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除 0 normal ，1 deleted")
    private Integer isDel;

    public MatchCondition(Integer id, Integer matchId, Integer conditionId, Date createTime, Date updateTime, Integer isDel) {
        this.id = id;
        this.matchId = matchId;
        this.conditionId = conditionId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDel = isDel;
    }

    public MatchCondition() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "MatchCondition{" +
                "id=" + id +
                ", matchId=" + matchId +
                ", conditionId=" + conditionId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDel=" + isDel +
                '}';
    }
}
