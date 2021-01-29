package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: SpringCloud2021
 * @description:Eureka Server
 * @author: Gan
 * @date: 2021-01-24 16:06
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
