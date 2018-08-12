package com.testingedu.objectprogrammingfivedesignprinciples.代理模式;

public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("the real subject");
    }
}
