package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import org.springframework.stereotype.Service;

/**
* 说明: 多个线程同时执行 synchronized 修饰的方法时遵循如下规则:
*      synchronized 修饰类锁时是顺序执行 如下方法 doTaskA()和doTaskB(),
*      但synchronized 修饰对象锁时是异步执行的 如下方法 doTaskC()和doTaskD();
* */
@Service
public class Tasks {

    public synchronized static void doTaskA() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized static void doTaskB() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized void doTaskC() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized void doTaskD() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }
}
