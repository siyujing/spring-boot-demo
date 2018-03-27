package com.testingedu.objectprogrammingfivedesignprinciples.open_closed_principle开放封闭原则;

public class DrawMoneyProcess implements IBankProcess {
    @Override
    public void Process() {
        // 办理取款业务
        System.out.println("DrawMoneyProcess");
    }
    //  endregion
}
