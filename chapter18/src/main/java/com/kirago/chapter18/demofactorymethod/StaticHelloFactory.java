package com.kirago.chapter18.demofactorymethod;

import com.kirago.chapter18.demoalias.Hello;

public class StaticHelloFactory {

    public static Hello getHello(){
        Hello hello = new Hello();
        hello.setContent("Hello world!");
        return hello;
    }
}
