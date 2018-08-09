package com.testingedu.objectprogrammingfivedesignprinciples.职责链模式;

public class ConcreteHandler3 extends Handler {
    @Override
    public void handlerRequest(String condition) {
        if (condition.equalsIgnoreCase("handler3")) {
            System.out.println("handler3.....ing...");
        } else {
            System.out.println("没有此的请求条件，请检查");
        }
    }
}
