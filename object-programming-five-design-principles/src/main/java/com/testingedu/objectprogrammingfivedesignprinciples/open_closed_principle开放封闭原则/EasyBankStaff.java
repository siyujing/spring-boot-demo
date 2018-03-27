package com.testingedu.objectprogrammingfivedesignprinciples.open_closed_principle开放封闭原则;


public class EasyBankStaff {

    private IBankProcess bankProc = null;

    public void HandleProcess(Client client)
    {
        bankProc = client.CreateProcess();
        bankProc.Process();
    }
}
