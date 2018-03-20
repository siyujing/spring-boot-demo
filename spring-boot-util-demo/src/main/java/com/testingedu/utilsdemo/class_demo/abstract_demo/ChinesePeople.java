package com.testingedu.utilsdemo.class_demo.abstract_demo;

public class ChinesePeople extends People {
    @Override
    public void study() {
        System.out.println("studying");
    }

    public void speakChinese(){
        People people = new ChinesePeople();
        people.walk();
    }
}
