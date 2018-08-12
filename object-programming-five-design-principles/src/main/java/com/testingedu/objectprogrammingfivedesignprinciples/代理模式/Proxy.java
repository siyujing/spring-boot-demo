package com.testingedu.objectprogrammingfivedesignprinciples.代理模式;

import java.util.Objects;

public class Proxy extends Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if (Objects.isNull(realSubject)) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
