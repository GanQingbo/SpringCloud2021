package com.cloud.filter;

import com.cloud.security.TokenManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: SpringCloud2021
 * @description: 授权过滤器
 * @author: Gan
 * @date: 2021-02-19 12:30
 **/
public class TokenAuthenticationFilter extends BasicAuthenticationFilter {
    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    public TokenAuthenticationFilter(AuthenticationManager authenticationManager,TokenManager tokenManager,RedisTemplate redisTemplate){
        super(authenticationManager);
        this.tokenManager=tokenManager;
        this.redisTemplate=redisTemplate;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取当前认证成功用户权限信息
        UsernamePasswordAuthenticationToken authRequest=getAuthentication(request);
        //判断如果有权限信息，放到权限上下文中
        if(authRequest!=null){
            SecurityContextHolder.getContext().setAuthentication(authRequest);
        }
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        //从header获取token
        String token=request.getHeader("token");
        if(token!=null){
            String username=tokenManager.getUserInfoFromToken(token);
            //从redis获取权限列表
            List<String> permissionValueList = (List<String>) redisTemplate.opsForValue().get(username);

            //要放到Collection<GrantedAuthority>中返回
            Collection<GrantedAuthority> authorities=new ArrayList<>();
            for(String permission:permissionValueList){
                SimpleGrantedAuthority auth=new SimpleGrantedAuthority(permission);
                authorities.add(auth);
            }
            return new UsernamePasswordAuthenticationToken(username,token,authorities);
        }
        return null;
    }
}
