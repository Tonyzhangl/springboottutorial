package com.kirago.spring.aop.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoTest {
    
    @Test
    public void test(){
        final UserDao userDao = new UserDaoImpl();
        
        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("记录日志");
                        Object result = method.invoke(userDao, args);
                        return result;
                    }
                });
        proxy.saveUser();
    }

}