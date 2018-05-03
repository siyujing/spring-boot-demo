package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

public class ThreadA extends Thread{


    private Tasks tasks;

    @Override
    public void run() {
        tasks.doTaskA();
    }
}
