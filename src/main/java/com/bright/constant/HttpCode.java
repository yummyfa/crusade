package com.bright.constant;

public class HttpCode {

    private HttpCode() {
        throw new IllegalStateException("Utility class");
    }

    // 参数错误
    public final static int CODE_400 = 400;
    // 程序发生错误
    public final static int CODE_500 = 500;
    // ok
    public final static int CODE_200 = 200;
    // 网关访问错误
    public final static int CODE_502 = 502;
    // 访问地址不存在
    public final static int CODE_404 = 404;
}