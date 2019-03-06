package com.kirago.chapter05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chapter05Application {

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean(new )
    }
    public static void main(String[] args) {
        SpringApplication.run(Chapter05Application.class, args);
    }
}
