package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

public class ThreadB extends Thread{


    private Tasks tasks;

    @Override
    public void run() {
        Tasks.doTaskB();
    }
}
