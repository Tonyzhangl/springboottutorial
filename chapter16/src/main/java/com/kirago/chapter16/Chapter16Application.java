package com.kirago.chapter16;

import com.kirago.chapter16.config.TaskSchedulerConfig;
import com.kirago.chapter16.service.SchedulerdTaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Chapter16Application {

    public static void main(String[] args) {
//        SpringApplication.run(Chapter16Application.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

    }

}
