package com.cloud.security;

import com.cloud.utils.utils.R;
import com.cloud.utils.utils.ResponseUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: SpringCloud2021
 * @description: 退出处理器
 * @author: Gan
 * @date: 2021-02-19 11:04
 **/
public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    //构造
    public TokenLogoutHandler(TokenManager tokenManager,RedisTemplate redisTemplate){
        this.tokenManager=tokenManager;
        this.redisTemplate=redisTemplate;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication) {
        //1.从header里面获取token
        //2.token不为空，移除token，从redis删除token
        String token=request.getHeader("token");
        if(token!=null){
            //移除
            tokenManager.removeToken(token);
            //从token获取用户名
            String username=tokenManager.getUserInfoFromToken(token);
            redisTemplate.delete(username);
        }
        ResponseUtil.out(httpServletResponse, R.ok());
    }
}
