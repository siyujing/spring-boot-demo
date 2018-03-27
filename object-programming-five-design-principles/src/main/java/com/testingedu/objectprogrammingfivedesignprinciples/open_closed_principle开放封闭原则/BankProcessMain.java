package com.testingedu.objectprogrammingfivedesignprinciples.open_closed_principle开放封闭原则;

public class BankProcessMain {

    public static void main(String[] args) {
        EasyBankStaff bankStaff = new EasyBankStaff();
        bankStaff.HandleProcess(new Client("转账用户"));
    }
}
