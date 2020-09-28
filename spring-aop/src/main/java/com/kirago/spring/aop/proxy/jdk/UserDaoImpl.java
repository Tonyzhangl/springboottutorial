package com.kirago.spring.aop.proxy.jdk;

public class UserDaoImpl implements UserDao{
    
    @Override
    public void saveUser(){
        System.out.println("持久层：用户保存！");
    }
}
