package com.testingedu.objectprogrammingfivedesignprinciples.interface_segregation_principle接口隔离原则;

/**
 使用场合,提供调用者需要的方法,屏蔽不需要的方法.满足接口隔离原则.比如说电子商务的系统,有订单这个类,有三个地方会使用到,
 一个是门户,只能有查询方法,
 一个是外部系统,有添加订单的方法,
 一个是管理后台,添加删除修改查询都要用到.
 根据接口隔离原则(ISP),一个类对另外一个类的依赖性应当是建立在最小的接口上.
 也就是说,对于门户,它只能依赖有一个查询方法的接口.
 */
public class TestCreateLimitMain {

    public static void main(String[] args) {
        // 这样就能很好的满足接口隔离原则了，调用者只能访问它自己的方法，不能访问不该访问的方法。

        IOrderForPortal iOrderForPortal = Order.getIOrderForPortal();
        iOrderForPortal.getOrder();
        System.out.println("----------------------");

        IOrderForOtherSys iOrderForOtherSys = Order.getIOrderForOtherSys();
        iOrderForOtherSys.getOrder();
        iOrderForOtherSys.insertOrder();
        System.out.println("++++++++++++++++++++++++");

        IOrderForAdmin iOrderForAdmin = Order.getIOrderForAdmin();
        iOrderForAdmin.getOrder();
        iOrderForAdmin.deleteOrder();
        iOrderForAdmin.insertOrder();
        iOrderForAdmin.updateOrder();
    }

}
