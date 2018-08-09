package com.testingedu.utilsdemo.design_patterns.signletons;

/**
 * 双重校验锁，较常用,解决了线程问题和效率问题，比较常用
 */
public class SingletonSynchronized {
    private SingletonSynchronized() {
    }

    private static SingletonSynchronized singleton = null;

    public static SingletonSynchronized getInstance() {
        if (singleton == null) {
            synchronized (SingletonSynchronized.class) {
                singleton = new SingletonSynchronized();
            }
        }
        return singleton;
    }
}
