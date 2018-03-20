package com.testingedu.utilsdemo.MultiThread;

public class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            for (int i = 0; i < 1; i++) {
                System.out.println("myRunnable1:" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable1());
        thread.start();
        System.out.println("++++");
    }
}
