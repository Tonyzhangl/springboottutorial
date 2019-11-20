package com.kirago.aop;

public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
