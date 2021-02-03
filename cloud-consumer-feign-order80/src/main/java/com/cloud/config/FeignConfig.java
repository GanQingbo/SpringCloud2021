package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloud2021
 * @description: Feign日志配置Bean
 * @author: Gan
 * @date: 2021-01-31 23:23
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        //日志级别
        return Logger.Level.FULL;
    }
}
