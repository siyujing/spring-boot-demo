package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.简单工厂模式;

public class OperationFactory {

    public static Operation getOperation(String opt) {
        Operation operation = null;

        switch (opt) {
            case "+":
                operation = new OperationAdd();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}
