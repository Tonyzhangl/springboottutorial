package com.kirago.aop;

import java.lang.reflect.Method;

public class BeforeAdvice implements Advice{

    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        //在目标方法调用前执行通知
        methodInvocation.invoke();
        return method.invoke(bean, args);
    }
}
