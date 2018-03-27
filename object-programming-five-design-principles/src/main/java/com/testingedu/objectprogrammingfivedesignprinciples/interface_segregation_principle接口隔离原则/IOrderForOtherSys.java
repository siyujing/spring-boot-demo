package com.testingedu.objectprogrammingfivedesignprinciples.interface_segregation_principle接口隔离原则;

// 外部系统
public interface IOrderForOtherSys {
    String insertOrder();
    String getOrder();
}
