package com.kirago.quartz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.kirago.quartz.demo.dao"})
public class SpringbootQuartzDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootQuartzDemoApplication.class, args);
    }

}
