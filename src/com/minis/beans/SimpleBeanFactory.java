package com.minis.beans;

import java.util.*;

/**
 * @Description:
 * @Author: Levi
 * @Date: 2024/5/22 12:03
 */

public class SimpleBeanFactory implements BeanFactory{
    private List <BeanDefinition>beanDefinitions = new ArrayList<>();
    private List <String>beanNames = new ArrayList<>();
    private Map <String,Object>singletons = new HashMap<>();
    public SimpleBeanFactory() { }
    @Override
    public Object getBean(String beanName) throws BeansException {
        // 这里的beanName其实就是ID
        Object singleton = this.singletons.get(beanName);
        if(Objects.isNull(singleton)){
            int indexOf = this.beanNames.indexOf(beanName);
            if(indexOf == -1){
                throw new BeansException("不存在该bean" + beanName);
            }else {
                BeanDefinition beanDefinition = this.beanDefinitions.get(indexOf);
                try {
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                this.singletons.put(beanName,singleton);
            }
        }
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.add(beanDefinition);
        this.beanNames.add(beanDefinition.getId());
    }
}