package com.minis.beans;

/**
 * @Description: 把bean数据信息解析配置为类结构，存储为内存元数据
 * @Author: Levi
 * @Date: 2024/5/22 11:04
 */
public class BeanDefinition {
    private String id;
    private String className;

    public BeanDefinition() {}

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}