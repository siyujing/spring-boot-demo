package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.工厂方法模式;

public class AddOperation extends Operation {
    @Override
    public String getResult() {
        final double value = getNumberA() + getNumberB();
        return String.valueOf(value);
    }
}
