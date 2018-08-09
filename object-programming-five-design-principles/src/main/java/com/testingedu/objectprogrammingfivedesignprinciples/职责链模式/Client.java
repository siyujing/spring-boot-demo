package com.testingedu.objectprogrammingfivedesignprinciples.职责链模式;

import org.springframework.stereotype.Service;

@Service
public class Client {

    public void clientRequest() {

        ConcreteHandler1 concreteHandler1 = new ConcreteHandler1();
        ConcreteHandler2 concreteHandler2 = new ConcreteHandler2();
        ConcreteHandler3 concreteHandler3 = new ConcreteHandler3();

        concreteHandler1.successor = concreteHandler2;
        concreteHandler2.successor = concreteHandler3;


        concreteHandler1.handlerRequest("handler1");
    }
}
