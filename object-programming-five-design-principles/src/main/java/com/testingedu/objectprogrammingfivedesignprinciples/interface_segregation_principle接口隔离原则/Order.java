package com.testingedu.objectprogrammingfivedesignprinciples.interface_segregation_principle接口隔离原则;


public class Order implements IOrderForAdmin,IOrderForOtherSys,IOrderForPortal{

    // 创建无参私有方法目的是不让用户直接new 访问他不需要的方法
    private Order(){
    }


    public static IOrderForPortal getIOrderForPortal(){
        return new Order();
    }

    public static IOrderForOtherSys getIOrderForOtherSys(){
        return new Order();
    }

    public static IOrderForAdmin getIOrderForAdmin(){
        return new Order();
    }


    @Override
    public String deleteOrder() {
        System.out.println("delete order");
        return "delete order";
    }

    @Override
    public String updateOrder() {
        System.out.println("update order");
        return "update order";
    }

    @Override
    public String insertOrder() {
        System.out.println("insert order");
        return "insert order";
    }

    @Override
    public String getOrder() {
        System.out.println("get order");
        return "get order";
    }

}
