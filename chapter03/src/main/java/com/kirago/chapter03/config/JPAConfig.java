package com.kirago.chapter03.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @ClassName JPAConfig
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/9 11:03
 * @Version 1.0
 **/
@Configuration
@EnableJpaRepositories("com.kirago.chapter03.config")
@EntityScan("com.kirago.chapter03.model")
public class JPAConfig {
}
