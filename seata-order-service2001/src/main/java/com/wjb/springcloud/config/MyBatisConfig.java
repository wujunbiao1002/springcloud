package com.wjb.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.wjb.springcloud.dao"})
public class MyBatisConfig {
}
