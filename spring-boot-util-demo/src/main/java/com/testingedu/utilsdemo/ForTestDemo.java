package com.testingedu.utilsdemo;


public class ForTestDemo {

    public synchronized void methodA() {//对当前对象加锁

    }


    public void methodB() {

        synchronized (this) {
        }//对当前对象加锁，与methodA用法相同

    }

    public static synchronized void methodC() {
    }//对类加锁，即对所有此类的对象加锁

    public void methodD() {
        synchronized (ForTestDemo.class) {
        }//对类加锁，即对所有此类的对象加锁

    }
}
