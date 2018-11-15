package com.testingedu.utilsdemo.MultiThread.my_thread;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * */
public class TestPriority {

    public static void main(String[] args) {
        MyThread4 myThread4 = new MyThread4("a");
        MyThread5 myThread5 = new MyThread5("bbbbbbb");
        System.out.println(myThread4.getPriority());
        System.out.println(myThread5.getPriority());
        myThread5.setPriority(9);
        System.out.println(myThread5.getPriority());
        myThread5.start();
        myThread4.start();
        System.out.println(myThread5.getPriority());
    }

    protected static class MyThread4 extends Thread {
        MyThread4(String name) {
            super(name);
        }

        @Autowired
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 50; i++) {
                System.out.println(getName() + ":" + i);
            }
        }
    }

    protected static class MyThread5 extends Thread {
        MyThread5(String name) {
            super(name);
        }

        @Autowired
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 50; i++) {
                System.out.println(getName() + ":" + i);
            }
        }
    }
}
