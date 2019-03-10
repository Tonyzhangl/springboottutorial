package com.kirago.chapter14;

import com.kirago.chapter14.config.AwareConfig;
import com.kirago.chapter14.service.AwareService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Chapter14Application {

    public static void main(String[] args) {
//        SpringApplication.run(Chapter14Application.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);

        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();

        context.close();
    }

}
