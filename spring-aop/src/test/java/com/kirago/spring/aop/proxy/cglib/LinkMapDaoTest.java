package com.kirago.spring.aop.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class LinkMapDaoTest {

    @Test
    public void save() {
        final LinkMapDao linkMapDao = new LinkMapDao();
        
        Enhancer enhancer = new Enhancer();
        
        enhancer.setSuperclass(linkMapDao.getClass());
        
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("记录日志");
                Object result = method.invoke(linkMapDao, objects);
                return  result;
            }
        });
        
        LinkMapDao proxy = (LinkMapDao) enhancer.create();
        proxy.save();
    }
}