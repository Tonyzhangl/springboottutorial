package com.kirago.aop;

import java.lang.reflect.Proxy;

/**
* @Description:    生成代理类
* @Author:         kirago
* @CreateDate:     2019/11/20 10:26 AM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SimpleAop {

    public static Object getProxy(Object bean,Advice advice) {
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
    }
}
