package com.testingedu.objectprogrammingfivedesignprinciples.open_closed_principle开放封闭原则;

public class Client {

    private String ClientType;


    public Client(String clientType) {
        ClientType = clientType;
    }

    public IBankProcess CreateProcess() {
        switch (ClientType) {
            case "存款用户":
                return new DepositProcess();
            case "转账用户":
                return new TransferProcess();
            case "取款用户":
                return new DrawMoneyProcess();
            default:
                return null;
        }
    }
}
