package com.bright.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: wangliang
 * @Date: 2021/12/8 11:31
 */
public class EntryConditionDto {

    private Integer matchId;

    @ApiModelProperty(value = "天气")
    private String weather;
    /**
     * 温度
     */
    @ApiModelProperty(value = "温度")
    private String temperature;
    /**
     * 湿度
     */
    @ApiModelProperty(value = "湿度")
    private String humidity;

    public EntryConditionDto(Integer matchId, String weather, String temperature, String humidity) {
        this.matchId = matchId;
        this.weather = weather;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public EntryConditionDto() {
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
