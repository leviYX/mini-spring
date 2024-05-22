package com.minis.test;


import com.minis.beans.BeansException;
import com.minis.beans.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: Levi
 * @Date: 2024/5/22 11:30
 */

public class Test1 {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx = new
                ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService)ctx.getBean("aservice");
        aService.sayHello();
    }
}