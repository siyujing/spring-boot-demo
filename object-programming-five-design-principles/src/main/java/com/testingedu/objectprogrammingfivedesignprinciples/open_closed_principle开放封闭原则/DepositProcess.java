package com.testingedu.objectprogrammingfivedesignprinciples.open_closed_principle开放封闭原则;

public class DepositProcess implements IBankProcess {

    @Override
    public void Process() {
    // 办理存款业务
        System.out.println("DepositProcess");
    }

    // endregion
}
