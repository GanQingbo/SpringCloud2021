package com.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author G
 * @version 1.0
 * @date 2021/2/17 10:54
 */
@Configuration
@MapperScan({"com.cloud.dao"})
public class MyBatisConfig {
}
