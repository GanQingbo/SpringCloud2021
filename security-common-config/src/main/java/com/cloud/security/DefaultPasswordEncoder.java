package com.cloud.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: SpringCloud2021
 * @description: 密码处理工具类
 * @author: Gan
 * @date: 2021-02-19 10:41
 **/
public class DefaultPasswordEncoder implements PasswordEncoder {
    //构造方法
    public DefaultPasswordEncoder(){
        this(-1);
    }
    public DefaultPasswordEncoder(int strength){

    }
    //md5加密
    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    //密码比对
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
