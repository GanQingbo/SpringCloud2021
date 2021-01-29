package com.cloud.entities;

/**
 * @author G
 * @version 1.0
 * @date 2021/1/20 10:32
 */

/**
 * Json封装类
 * @param <T>
 */
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    /**
     * 三个构造方法
     */
    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
