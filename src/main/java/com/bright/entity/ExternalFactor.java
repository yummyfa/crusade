package com.bright.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: wangliang
 * @Date: 2021/11/25 9:30
 */
public class ExternalFactor {

    /**
     * 因素id
     */
    @ApiModelProperty(value = "因素id")
    private Integer factorId;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "是否删除 0 normal ，1 deleted")
    private Integer isDel;

    public ExternalFactor(Integer factorId, String content, Integer isDel) {
        this.factorId = factorId;
        this.content = content;
        this.isDel = isDel;
    }

    public ExternalFactor() {
    }

    public Integer getFactorId() {
        return factorId;
    }

    public void setFactorId(Integer factorId) {
        this.factorId = factorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "ExternalFactor{" +
                "factorId=" + factorId +
                ", content='" + content + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
