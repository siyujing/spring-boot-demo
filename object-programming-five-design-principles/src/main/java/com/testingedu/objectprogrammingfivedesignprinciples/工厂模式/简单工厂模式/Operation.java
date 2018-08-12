package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.简单工厂模式;

import lombok.Data;

@Data
public abstract class Operation {
    private double numberA;
    private double numberB;

    public abstract String getResult();
}
