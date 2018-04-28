package com.testingedu.utilsdemo.test_volatile;

/**
 如下线程会出现死循环,原因如下:
 java内存分为工作内存和主存
 工作内存：即java线程的本地内存，是单独给某个线程分配的，存储局部变量等，同时也会复制主存的共享变量作为本地
 的副本，目的是为了减少和主存通信的频率，提高效率。
 主存：存储类成员变量等

 可见性是指的是线程访问变量是否是最新值。
 局部变量不存在可见性问题，而共享内存就会有可见性问题，
 因为本地线程在创建的时候，会从主存中读取一个共享变量的副本，且修改也是修改副本，
 且并不是立即刷新到主存中去，那么其他线程并不会马上共享变量的修改。
 因此，线程B修改共享变量后，线程A并不会马上知晓，就会出现上述死循环的问题。

 解决共享变量可见性问题，需要用volatile关键字修饰。

 * */
public class Task1 implements Runnable{
    volatile boolean running = true; // 把变量类型设置为 volatile 即:volatile boolean running = true, 会解决线程死循环的问题
    int i = 0;

    @Override
    public void run() {
        while (running) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task1 task = new Task1();
        Thread th = new Thread(task);
        th.start();
        Thread.sleep(100);
        System.out.println(task.i);

        Thread.sleep(100);
        task.running = false;

        Thread.sleep(1);
        System.out.println(task.i);

        Thread.sleep(1000);
        System.out.println(task.i);
    }
}
