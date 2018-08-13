package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.工厂方法;

public class DivOperation extends Operation{
    @Override
    public String getResult() {
        if (super.getNumberB() != 0) {
            final double v = getNumberA() / getNumberB();
            return String.valueOf(v);

        } else {
            return "除数不能为0";
        }
    }
}
