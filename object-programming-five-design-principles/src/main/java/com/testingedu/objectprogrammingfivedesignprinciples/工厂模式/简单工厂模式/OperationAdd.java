package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.简单工厂模式;

public class OperationAdd extends Operation {
    @Override
    public String getResult() {
        final double result = super.getNumberA() + super.getNumberB();
        return String.valueOf(result);
    }
}
