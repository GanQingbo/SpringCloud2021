package com.cloud.config;

import com.cloud.filter.TokenAuthenticationFilter;
import com.cloud.filter.TokenLoginFilter;
import com.cloud.security.DefaultPasswordEncoder;
import com.cloud.security.TokenLogoutHandler;
import com.cloud.security.TokenManager;
import com.cloud.security.UnauthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @program: SpringCloud2021
 * @description: 核心配置类
 * @author: Gan
 * @date: 2021-02-19 15:57
 **/
@Configuration
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {
    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    //private DefaultPasswordEncoder defaultPasswordEncoder;
    private UserDetailsService userDetailsService;

    @Autowired
    public TokenWebSecurityConfig(UserDetailsService userDetailsService,TokenManager tokenManager,RedisTemplate redisTemplate){
        this.tokenManager=tokenManager;
        this.redisTemplate=redisTemplate;
        this.userDetailsService=userDetailsService;
        //this.defaultPasswordEncoder=defaultPasswordEncoder;
    }

    //设置退出的地址和Redis，token操作地址
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.exceptionHandling()
                .authenticationEntryPoint(new UnauthEntryPoint()) //没有权限访问
                .and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/admin/acl/index/logout")
                .addLogoutHandler(new TokenLogoutHandler(tokenManager,redisTemplate))
                //添加自定义的过滤器
                .and().addFilter(new TokenLoginFilter(authenticationManager(),tokenManager,redisTemplate))
                .addFilter(new TokenAuthenticationFilter(authenticationManager(),tokenManager,redisTemplate)).httpBasic();

    }

    //调用userDetailsService和密码处理
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncoder);
//    }

    //不进行认证的路径，直接访问
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/api/**");
    }
}
