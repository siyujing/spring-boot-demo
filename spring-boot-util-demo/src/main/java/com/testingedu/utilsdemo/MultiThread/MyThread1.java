package com.testingedu.utilsdemo.MultiThread;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int i=0;i<=100000;i++){
            System.out.println("myThread1:"+i);
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        for (int i=0;i<=100000;i++){
            System.out.println("localThread:"+i);
        }

    }

}
