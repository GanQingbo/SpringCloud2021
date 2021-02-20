package com.cloud.utils.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringCloud2021
 * @description: 统一返回结果
 * @author: Gan
 * @date: 2021-02-18 20:45
 **/
public class R {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String,Object> data=new HashMap<>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    //构造方法私有
    private R(){}

    //成功静态方法
    public static R ok(){
        R r=new R();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("this is ok");
        return r;
    }

    //失败
    public static R error(){
        R r=new R();
        r.setSuccess(false);
        r.setCode(444);
        r.setMessage("this is error");
        return r;
    }

    //其它方法
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
