package com.testingedu.objectprogrammingfivedesignprinciples.职责链模式;

public class ConcreteHandler1 extends Handler{
    @Override
    public void handlerRequest(String condition) {
        if (condition.equalsIgnoreCase("handler1")){
            System.out.println("handler1.....ing...");
        }else {
            successor.handlerRequest(condition);
        }
    }
}
