package com.minis.beans;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * @Description:对xml资源的处理，解析出来封装在元素集合里面
 * @Author: Levi
 * @Date: 2024/5/22 12:00
 */

public class ClassPathXmlResource implements Resource{
    Document document;
    Element rootElement;
    Iterator<Element> elementIterator;
    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        //将配置文件装载进来，生成一个迭代器，可以用于遍历
        try {
            this.document = saxReader.read(xmlPath);
            this.rootElement = document.getRootElement();
            this.elementIterator = this.rootElement.elementIterator();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }
    @Override
    public Object next() {
        return this.elementIterator.next();
    }
}