package com.testingedu.utilsdemo.class_demo.abstract_demo;

/**
 　　　　　　　　1：成员属性必须不能是 private(私有) 修饰符修

 　　　　　　　　2：成员方法可包含普通方法(虚方法)和abstract(抽象)修饰的成员方法

 　　　　　　　　3：子类可选择性的重写虚方法，必须实现父类的所有抽象方法
 * */
public abstract class People {

    public abstract void study();

    public void walk(){
        System.out.println("walking");
    }
}
