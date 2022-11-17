package com.fj.pojo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/31 11:26    since 1.0.0
 */
public class Dom4jTest {
    @Test
    public void Test1() throws Exception{
        //创建一个SaxReader输入流 去读取xml配置文件 生成Document对象
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read("src/books.xml");
        System.out.println("document = " + document);
    }
    //读取books.xml文件生成book类
    @Test
    public void test2() throws DocumentException {
        //读取book文件
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //通过Document获取对象根元素
        Element rootElement = document.getRootElement();
        System.out.println("rootElement = " + rootElement);
        //通过根元素获取book标签信息
        // element() elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //遍历处理每个book标签转换为books类
        //book.asXML()标签对象转换为标签字符串
        for (Element book : books) {
//            System.out.println("book.asXML() = " + book.asXML());
//            Element name = book.element("name");
//            Element price = book.element("price");
//            Element author = book.element("author");
            //.getText()获取标签·中的文本·内容
//            System.out.println("name = " + name.getText());
//            System.out.println("price = " + price.getText());
//            System.out.println("author = " + author.getText());
            //直接获取指定标签的内容
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            //获取属性值
            String sn = book.attributeValue("sn");
//            System.out.println("sn = " + sn);
//            System.out.println("name = " + name);
//            System.out.println("price = " + price);
//            System.out.println("author = " + author);
//            System.out.println();
            System.out.println(new Book(sn,name,Double.parseDouble(price),author));
            //



        }
    }
}
