package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.简单工厂模式;

/**
 * 除法操作
 */
public class OperationDiv extends Operation {
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
