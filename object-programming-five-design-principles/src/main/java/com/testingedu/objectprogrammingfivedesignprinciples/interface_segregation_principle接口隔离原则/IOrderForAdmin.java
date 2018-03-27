package com.testingedu.objectprogrammingfivedesignprinciples.interface_segregation_principle接口隔离原则;

// 后台管理
public interface IOrderForAdmin {
    String deleteOrder();
    String updateOrder();
    String insertOrder();
    String getOrder();
}
