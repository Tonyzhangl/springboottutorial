package com.kirago.chapter18.demofactorybean.factorybean;

import com.kirago.chapter18.demoalias.Hello;
import com.kirago.chapter18.demofactorybean.bean.HelloBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class HelloFactoryBean implements FactoryBean<HelloBean> {

    @Override
    public HelloBean getObject() throws Exception {

        return new HelloBean();
    }

    @Override
    public Class<?> getObjectType() {
        return HelloBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
