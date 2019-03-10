package com.kirago.chapter16.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/10 10:30 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class SchedulerdTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每个五秒钟执行一次:" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecution() {
        System.out.println("在指定的时间" + dateFormat.format(new Date()) + "执行");
    }
}
