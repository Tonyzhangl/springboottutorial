package com.kirago.chapter18.demobeanpostprocessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/15 3:12 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class LoggerBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        System.out.println("Before " + beanName + " Initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        System.out.println("After " + beanName + " Initialization");
        return bean;
    }
}
