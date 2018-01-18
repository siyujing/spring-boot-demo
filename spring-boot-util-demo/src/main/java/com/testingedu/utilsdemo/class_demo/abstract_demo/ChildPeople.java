package com.testingedu.utilsdemo.class_demo.abstract_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象类可以被实例化,但是必须实现抽象方法
 *
 * 接口不可以被实例化
 */
public class ChildPeople {
    public void speak(){
        EnglishPeople child = new EnglishPeople();
        child.walk();
        child.study();
        child.speakingEnglish();
    }

    public void peak2(){
        People child = new EnglishPeople();
        child.walk();
        child.study();
        // 没有此方法
//        child.speakingEnglish();
    }

    public void peak3(){
        People child = new People() {
            @Override
            public void study() {
                System.out.println("new study");
            }
        };
        child.walk();
        child.study();
        // 没有此方法
//        child.speakingEnglish();

    }

    public void listDemo(){
        List<String> list = new ArrayList<>();

        // 接口不能被实例化,以下定义不对
//        List<String> list1 = new List<>();
    }
}
