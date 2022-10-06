package com.bright.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @author wangliang
 * @date 2022/10/5 23:11
 */
public class MatchDto {
    @NotBlank(message = "主队名称不能为空")
    @ApiModelProperty(value = "主队名称")
    private String host;

    @NotBlank(message = "客队名称不能为空")
    @ApiModelProperty(value = "客队名称")
    private String guest;

    @ApiModelProperty(value = "具体比赛时间")
    private String time;

    @ApiModelProperty(value = "比赛年份")
    private String year;

    @NotBlank(message = "赛事名称不能为空")
    @ApiModelProperty(value = "赛事名称")
    private String warName;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWarName() {
        return warName;
    }

    public void setWarName(String warName) {
        this.warName = warName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
