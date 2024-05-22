package com.minis.beans;

/**
 * @Description:
 * @Author: Levi
 * @Date: 2024/5/22 11:59
 */

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    void registerBeanDefinition(BeanDefinition beanDefinition);
}