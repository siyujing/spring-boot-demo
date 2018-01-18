package com.testingedu.utilsdemo.class_demo.interface_demo;

public class Dog {

    public void test1(){
        Animal dog = new AnimalImp();
        dog.startRun();
        dog.startCry();
    }

    public void test2(){
        Animal dog = new AnimalImp();
        dog.startRun();
    }
}
