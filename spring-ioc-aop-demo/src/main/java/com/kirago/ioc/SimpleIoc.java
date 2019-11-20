package com.kirago.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    SimpleIoc 实现 IOC简单代码示例及流程分析
 * 1、加载 xml 文件配置，遍历其中的标签
 * 2、获取其中的id 及 class 属性，加载 class 属性对应的类并创建bean
 * 3、遍历标签中的标签，并将 属性填充到 bean 中
 * 4、将 bean 注入到容器中
 * 参考 博客 http://www.tianxiaobo.com/2018/01/18/%E8%87%AA%E5%B7%B1%E5%8A%A8%E6%89%8B%E5%AE%9E%E7%8E%B0%E7%9A%84-Spring-IOC-%E5%92%8C-AOP-%E4%B8%8A%E7%AF%87/
* @Author:         kirago
* @CreateDate:     2019/11/19 5:03 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SimpleIoc {
    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIoc(String location) throws Exception {
        loadBeans(location);
    }

    /**
     *
     * @param name
     * @return Object
     */
    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if(bean == null) {
            throw new IllegalArgumentException("there is no bean with name: " + name);
        }
        return bean;
    }

    private void loadBeans(String location) throws Exception {
        // 加载 xml 配置文件
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();

        // 遍历 <bean> 标签
        for(int i=0;i<nodeList.getLength();i++) {
           Node node = nodeList.item(i);
           if(node instanceof Element) {
               Element element = (Element) node;
               String id = element.getAttribute("id");
               String className = element.getAttribute("class");

               // 加载 bean Class
               Class beanClass = null;
               try {
                   beanClass = Class.forName(className);
               }catch (ClassNotFoundException e) {
                   e.printStackTrace();
                   return;
               }

               // 创建 bean
               Object bean = beanClass.newInstance();

               // 遍历 <property> 便签
               NodeList propertyNodes = element.getElementsByTagName("property");
               for(int j=0;j<propertyNodes.getLength();j++) {
                   Node propertyNode = propertyNodes.item(j);
                   if(propertyNode instanceof Element) {
                       Element propertyElement = (Element) propertyNode;
                       String name = propertyElement.getAttribute("name");
                       String value = propertyElement.getAttribute("value");

                       // 利用反射将bean相关字段访问权限设置为可访问
                       Field declaredField = bean.getClass().getDeclaredField(name);
                       declaredField.setAccessible(true);

                       if(value != null && value.length() > 0) {
                           // 将属性填充到对应的属性名中
                           declaredField.set(bean, value);
                       }else {
                           String ref = propertyElement.getAttribute("ref");
                           if( ref == null && ref.length() == 0) {
                               throw new IllegalArgumentException("ref config error");
                           }

                           // 将引用填充到x相关字段中
                           declaredField.set(bean, getBean(ref));
                       }

                       // 将 bean 注入到容器中
                       registerBean(id, bean);
                   }
               }

           }
        }

    }

    private void registerBean(String id,Object bean) {
        beanMap.put(id, bean);
    }
}
