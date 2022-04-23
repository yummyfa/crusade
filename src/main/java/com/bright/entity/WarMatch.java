package com.bright.entity;

/**
 * @author wangliang
 * @date 2022/4/23 20:49
 */
public class WarMatch {

    private Integer warId;

    private Integer matchId;

    private Integer isDel;

    public WarMatch(Integer warId, Integer matchId, Integer isDel) {
        this.warId = warId;
        this.matchId = matchId;
        this.isDel = isDel;
    }

    public WarMatch() {
    }

    public Integer getWarId() {
        return warId;
    }

    public void setWarId(Integer warId) {
        this.warId = warId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}


