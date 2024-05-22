package com.minis.beans;

/**
 * @Description:通过xml的URL来解析xml中的bean数据，存储为beanDefinitions，
 * 并且通过反射来创建出来bean存放于单例池中
 * @Author: Levi
 * @Date: 2024/5/22 11:05
 */

public class ClassPathXmlApplicationContext implements BeanFactory{
    BeanFactory beanFactory;
    //构造器获取外部配置，解析出Bean的定义，形成内存映像
    public ClassPathXmlApplicationContext(String fileName) {
        ClassPathXmlResource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }


    //这是对外的一个方法，让外部程序从容器中获取Bean实例，会逐步演化成核心方法
    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}