package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloud2021
 * @description: 规则配置类
 * @author: Gan
 * @date: 2021-01-30 23:26
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //定义为随机
        return new RandomRule();
    }
}
