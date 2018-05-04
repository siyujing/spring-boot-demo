package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 说明: 多个线程同时执行 synchronized 修饰的 方法 时遵循如下规则(如果直接修饰变量或者类则是 顺序 即同步执行的):
 * synchronized 修饰类锁时是顺序执行 如下方法 doTaskA()和doTaskB(),
 * 但synchronized 修饰对象锁时是异步执行的 如下方法 doTaskC()和doTaskD();
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
