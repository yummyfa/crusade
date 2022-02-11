package com.bright.req;

/**
 * @Author: wangliang
 * @Date: 2021/12/8 14:33
 */
public class EntryFactorReq {

    private Integer match;

    private Integer factor;

    public EntryFactorReq(Integer match, Integer factor) {
        this.match = match;
        this.factor = factor;
    }

    public EntryFactorReq() {
    }

    public Integer getMatch() {
        return match;
    }

    public void setMatch(Integer match) {
        this.match = match;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }
}
