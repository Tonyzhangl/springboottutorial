package com.kirago.chapter15.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/10 10:03 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer integer) {
        System.out.println("执行异步任务:" + integer);
    }

    @Async
    public void executeAsyncPlusTask(Integer integer){
        System.out.println("执行异步任务+1:" + integer+1);
    }
}
