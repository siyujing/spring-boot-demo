package com.testingedu.utilsdemo.MultiThread.my_thread;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * yield();  // 高风亮节，当前线程遇到yield() 方法会高风亮节让出CPU 让其他线程执行一会。
 */
public class TestYield {

    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3("t1......");
        MyThread3 t2 = new MyThread3("t2");
        t1.start();
        t2.start();
    }

    protected static class MyThread3 extends Thread {
        public MyThread3(String name) {
            super(name);
        }

        @Autowired
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(getName() + ":" + i);
                if (i % 10 == 0) {
                    yield();
                }
            }
        }
    }
}
