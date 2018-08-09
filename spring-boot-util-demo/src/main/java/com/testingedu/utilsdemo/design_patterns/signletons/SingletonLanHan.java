package com.testingedu.utilsdemo.design_patterns.signletons;


/**
 * 懒汉模式（线程不安全的，如果放在多线程的环境中就会有问题了。如果有两个线程同时访问getInstance方法，
 * 如果其中一个线程刚进入if (singleton == null){}里面，那么，这个时候另一个线程恰好也访问这个方法，
 * 并且完成创建了一个实例，那个刚刚挂起的那个线程继续运行的话就会再创建一个实例。）
 * 三个重点：
 * 1. 将构造方法私有化（保证外部不能直接构造）。
 * 2. 有一个静态属性指向实例.
 * 3. 提供一个公有的静态方法向外面提供这个实例。
 */
public class SingletonLanHan {

    // 1. 构造方法私有化
    private SingletonLanHan() {
    }

    // 2. 定义静态属性用于指向实例
    private static SingletonLanHan singleton = null;

    //3. 提供一个静态方法
    public static SingletonLanHan getInstance() {
        if (singleton == null) {
            singleton = new SingletonLanHan();
        }
        return singleton;
    }
}
