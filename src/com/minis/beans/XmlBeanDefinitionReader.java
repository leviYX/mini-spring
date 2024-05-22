package com.minis.beans;

import org.dom4j.Element;

/**
 * @Description:对于解析出来xmL资源的处理，把xml资源封装为BeanDefinition
 * 并且放在beanFactory中，此时就拿到所有的 BeanDefinitio了
 * @Author: Levi
 * @Date: 2024/5/22 12:02
 */

public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;
    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}