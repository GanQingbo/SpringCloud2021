package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: SpringCloud2021
 * @description: feign
 * @author: Gan
 * @date: 2021-01-31 22:22
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
