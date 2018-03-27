package com.testingedu.objectprogrammingfivedesignprinciples.open_closed_principle开放封闭原则;

public class TransferProcess implements IBankProcess {
    @Override
    public void Process() {
        // 办理转账业务
        System.out.println("TransferProcess");
    }
    //  endregion

    public void test(){

    }
}