package com.testingedu.objectprogrammingfivedesignprinciples.原型模式.基本原型模式;

import org.springframework.stereotype.Service;

/**
 * 原型模式克隆的时候会设计到深克隆和浅克隆的问题，克隆的对象包含数值型是不涉及深克隆和浅克隆，但是引用类型有时候需要深克隆。，深克隆方法是把对象转化成json字符串复制在反序列化比较简单
 * */

@Service
public class ClientPrototype {

    public void getConcreteResumt() {
        Resume concreteResume1 = new ConcreteResume1("id1");

        Resume concreteResumt2 = concreteResume1.clone();

        System.out.println("concreteResume1" + concreteResume1.toString());

        System.out.println("concreteResume2" + concreteResumt2.toString());

    }
}
