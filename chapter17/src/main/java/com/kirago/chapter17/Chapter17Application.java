package com.kirago.chapter17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter17Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter17Application.class, args);
        System.out.println("xxxxx");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

//        ListService listService = context.getBean(ListService.class);

//        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下list的命令为:" + listService.showListCmd());
    }

}
