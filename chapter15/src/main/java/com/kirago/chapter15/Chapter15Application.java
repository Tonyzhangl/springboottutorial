package com.kirago.chapter15;

import com.kirago.chapter15.config.TaskExecutorConfig;
import com.kirago.chapter15.demo.Demo;
import com.kirago.chapter15.service.AsyncTaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Chapter15Application {

    public static void main(String[] args) {
//        SpringApplication.run(Demo.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncPlusTask(i);
        }
        context.close();
    }

}
