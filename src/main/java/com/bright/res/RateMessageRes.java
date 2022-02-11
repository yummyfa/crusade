package com.bright.res;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: wangliang
 * @Date: 2021/12/4 18:18
 */
public class RateMessageRes {

    @ApiModelProperty(value = "一方")
    private String teamName;

    @ApiModelProperty(value = "概率")
    private RateRes rateRes;

    public RateMessageRes(String teamName, RateRes rateRes) {
        this.teamName = teamName;
        this.rateRes = rateRes;
    }

    public RateMessageRes() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public RateRes getRateRes() {
        return rateRes;
    }

    public void setRateRes(RateRes rateRes) {
        this.rateRes = rateRes;
    }
}
