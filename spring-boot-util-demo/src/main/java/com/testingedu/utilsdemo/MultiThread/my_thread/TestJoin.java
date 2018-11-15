package com.testingedu.utilsdemo.MultiThread.my_thread;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * join(); // 加入到当前的主线程
 */
public class TestJoin {

    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("abcde");
        t1.start();

        try {
            t1.join();      //  把 t1线程 加到当前的主线程，主线程会等待t1 线程执行完在执行当前的主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am main");
        }
    }

    protected static class MyThread2 extends Thread {
        protected MyThread2(String name) {
            super(name);
        }

        @Autowired
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i am thread" + getName());
            }

        }

    }
}
