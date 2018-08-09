package com.testingedu.objectprogrammingfivedesignprinciples.职责链模式;

public class ConcreteHandler2 extends Handler{
    @Override
    public void handlerRequest(String condition) {
        if (condition.equalsIgnoreCase("handler2")){
            System.out.println("handler2.....ing...");
        }else {
            successor.handlerRequest(condition);
        }
    }
}
