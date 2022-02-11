package com.bright.entity;

import com.bright.constant.HttpCode;

import java.io.Serializable;

/**
 * 自定义返回页面结果
 * @author zhoukeqin
 * @date 2021/6/15
 */
public class ResultTemplate<T> implements Serializable {

    private static final long serialVersionUID = -669633312320552296L;

    private ResultTemplate() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 返回成功，用于新增、编辑、删除操作
     * @param msg
     * @return
     */
    public static <T> ResultEntity<T> success(String msg) {
        ResultEntity<T>  result = new ResultEntity<T>();
        result.setSuccess(true);
        result.setCode(HttpCode.CODE_200);
        result.setMessage(msg);
        return result;
    }

    /**
     * 返回成功，用于查询
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> successData(T data, String msg) {
        ResultEntity<T> result = new ResultEntity<T>();
        result.setSuccess(true);
        result.setCode(HttpCode.CODE_200);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }


    /**
     * 返回成功，用于新增、编辑、删除操作
     * @param msg
     * @return
     */
    public static <T> ResultEntity<T> fail(String msg) {
        ResultEntity<T>  result = new ResultEntity<T>();
        result.setSuccess(false);
        result.setCode(HttpCode.CODE_500);
        result.setMessage(msg);
        return result;
    }

    /**
     * 错误，返回指定code&msg
     * @param code 错误编码
     * @param msg 错误内容
     * @param <T>
     * @return
     */
    public static <T> ResultEntity<T> error(Integer code, String msg) {
        ResultEntity<T>  result = new ResultEntity<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}