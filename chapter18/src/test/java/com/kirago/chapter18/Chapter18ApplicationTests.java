package com.kirago.chapter18;

import com.kirago.chapter18.demofactorybean.config.HelloFactoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter18ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAlias() {
        String configLocation = "application-alias.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("    alias-hello -> " + applicationContext.getBean("alias-hello"));
        System.out.println("double-alias-hello -> " + applicationContext.getBean("double-alias-hello"));
    }

    @Test
    public void testAutowire(){
        String configLocation = "application-autowire.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("service-without-autowire -> " + applicationContext.getBean("service-without-autowire"));
        System.out.println("service-with-autowire -> " + applicationContext.getBean("service-with-autowire"));
    }

    @Test
    public void testFactoryBean() {
//        String configLocation = "application-factorybean.xml";
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloFactoryConfig.class);
        System.out.println("helloFactory -> " + context.getBean("helloFactoryBean"));
        System.out.println("&helloFactory -> " + context.getBean("&helloFactoryBean"));
    }

}
