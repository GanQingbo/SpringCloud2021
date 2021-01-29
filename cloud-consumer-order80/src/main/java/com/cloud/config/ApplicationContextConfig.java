package com.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author G
 * @version 1.0
 * @date 2021/1/21 10:00
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //负载均衡
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
