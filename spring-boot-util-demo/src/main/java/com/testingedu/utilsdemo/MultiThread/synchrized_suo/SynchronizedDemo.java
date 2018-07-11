package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import com.testingedu.utilsdemo.ForTestDemo;

/**
 synchronized 修饰方法和代码块时：
 修饰静态方法和修饰类是一样的
 修饰非静态方法和修饰对象是一样的效果
 */

public class SynchronizedDemo {

    // 对 当前 对象加锁，属于对象锁
    public synchronized void methodA() {
        System.out.println("222");
    }

    // 对当前对象加锁，与methodA用法相同，相当于对象锁
    public void methodB() {
        synchronized (this) {
            System.out.println("sss");
        }
    }

    // 对类加锁，即对所有此类的对象加锁，属于类锁
    public static synchronized void methodC() {
        System.out.println("233");
    }

    //对类加锁，即对 所有 此类的对象加锁,相当于类锁
    public void methodD() {
        synchronized (SynchronizedDemo.class) {
            System.out.println("222");
        }
    }
}
