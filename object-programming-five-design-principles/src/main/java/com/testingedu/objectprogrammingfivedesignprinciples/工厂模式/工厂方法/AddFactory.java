package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.工厂方法;


public class AddFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new AddOperation();
    }
}
