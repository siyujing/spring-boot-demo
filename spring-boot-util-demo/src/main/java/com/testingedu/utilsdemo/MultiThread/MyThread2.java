package com.testingedu.utilsdemo.MultiThread;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100000; i++) {
            System.out.println("myThread____2:" + i);
        }
    }
}
