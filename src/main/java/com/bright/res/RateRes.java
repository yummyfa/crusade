package com.bright.res;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: wangliang
 * @Date: 2021/12/4 18:19
 */
public class RateRes {

    @ApiModelProperty(value = "胜")
    private String winRate;

    @ApiModelProperty(value = "败")
    private String loseRate;

    @ApiModelProperty(value = "平")
    private String drawRate;

    public RateRes(String winRate, String loseRate, String drawRate) {
        this.winRate = winRate;
        this.loseRate = loseRate;
        this.drawRate = drawRate;
    }

    public RateRes() {
    }

    public String getWinRate() {
        return winRate;
    }

    public void setWinRate(String winRate) {
        this.winRate = winRate;
    }

    public String getLoseRate() {
        return loseRate;
    }

    public void setLoseRate(String loseRate) {
        this.loseRate = loseRate;
    }

    public String getDrawRate() {
        return drawRate;
    }

    public void setDrawRate(String drawRate) {
        this.drawRate = drawRate;
    }
}
