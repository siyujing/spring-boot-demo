package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.简单工厂模式;

import org.springframework.stereotype.Service;

@Service
public class ClientCalculator {

    public void calculator() {
        final Operation operationAdd = OperationFactory.getOperation("+");
        operationAdd.setNumberA(5);
        operationAdd.setNumberB(9);
        final String result = operationAdd.getResult();
        System.out.println("result=" + result);

    }
}
