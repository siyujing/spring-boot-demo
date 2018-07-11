package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 java的对象锁和类锁：java的对象锁和类锁在锁的概念上基本上和内置锁是一致的，但是，两个锁实际是有很大的区别的，
 对象锁是用于对象实例方法，或者一个对象实例上的，类锁是用于类的静态方法或者一个类的class对象上的。
 我们知道，类的对象实例可以有很多个，但是每个类只有一个class对象，所以不同对象实例的对象锁是互不干扰的，但是每个类只有一个类锁。
 * */
/**
 * 说明: 多个线程同时执行 synchronized 修饰的 方法 时遵循如下规则(如果直接修饰变量或者类则是 顺序 即同步执行的):
 * synchronized 修饰 类锁 时是顺序执行 如下方法 doTaskA()和doTaskB(),
 * 但synchronized 修饰 对象锁 时是异步执行的 如下方法 doTaskC()和doTaskD();
 */
@Service
@Slf4j
public class Tasks {

    public synchronized static void doTaskA() {
        log.info("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized static void doTaskB() {
        log.info("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized void doTaskC() {
        log.info("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized void doTaskD() {
        log.info("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("name = " + Thread.currentThread().getName() + ", end");
    }
}
