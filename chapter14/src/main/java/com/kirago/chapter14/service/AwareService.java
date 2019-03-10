package com.kirago.chapter14.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/10 9:18 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setBeanName(String name){
        this.beanName = name;
    }

    public void outputResult() {
        System.out.println("Bean 的名称为:" + beanName);
        Resource resource = new ClassPathResource("aware/a.txt");

        try {
            System.out.println("文件加载的内容为:" + IOUtils.toString(resource.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
