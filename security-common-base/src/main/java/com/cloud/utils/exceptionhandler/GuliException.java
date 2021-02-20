package com.cloud.utils.exceptionhandler;

/**
 * @program: SpringCloud2021
 * @description:
 * @author: Gan
 * @date: 2021-02-18 20:44
 **/
public class GuliException extends RuntimeException {
    private Integer code; //状态码
    private String msg; //异常信息

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public GuliException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GuliException(String message, Integer code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public GuliException(String message, Throwable cause, Integer code, String msg) {
        super(message, cause);
        this.code = code;
        this.msg = msg;
    }

    public GuliException(Throwable cause, Integer code, String msg) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public GuliException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }

    public GuliException() {
    }
}
