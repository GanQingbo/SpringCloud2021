package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: SpringCloud2021
 * @description:
 * @author: Gan
 * @date: 2021-01-24 22:56
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }
}
