package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.工厂方法模式;

import org.springframework.stereotype.Service;

@Service
public class ClientCalculatorService {

    public void calcu() {
        IFactory addFactory = new AddFactory();
        Operation addOpera = addFactory.createOperation();
        addOpera.setNumberA(2);
        addOpera.setNumberB(3);
        String result = addOpera.getResult();
        System.out.println(result);

    }
}
