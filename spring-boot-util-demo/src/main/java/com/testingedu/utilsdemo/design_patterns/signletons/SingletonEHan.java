package com.testingedu.utilsdemo.design_patterns.signletons;

/**
 * 饿汉模式，比较费内存
 */
public class SingletonEHan {

    // 1. 构造方法私有化
    private SingletonEHan() {
    }

    // 2. 定义静态属性用于指向实例
    private static final SingletonEHan singleton = new SingletonEHan();

    // 3. 提供一个静态方法
    public static SingletonEHan getInstance() {
        return singleton;
    }
}
