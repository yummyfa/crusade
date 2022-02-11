package com.bright.entity;

/**
 * 返回实体类
 *
 * @param <T>
 */
public class ResultEntity<T> {

    private Integer code;
    private Boolean success;
    private String message;
    private T data;
    private Long dateLine;

    public Integer getCode() {
        if (null == code) {
            this.code = 200;
        }
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getDateLine() {
        if (null == dateLine) {
            this.dateLine = System.currentTimeMillis();
        }
        return dateLine;
    }

    public void setDateLine(Long dateLine) {
        this.dateLine = dateLine;
    }
}