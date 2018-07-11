package com.testingedu.utilsdemo.collection_demo;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * Vector 的插入删除等方法使用了synchronized，但是使用的是
 * */
@Slf4j
public class VectorAbout {
    public static void main(String[] args) {
        Vector<Object> vector = new Vector<>(2, 2);
        vector.add("abc");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("thread1 start");
                addA(vector, "f1");
                log.info("thread1 end");
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("thread2 start");
                addA(vector, "f2");
                log.info("thread2 end");
            }
        };
        runnable1.run();
        runnable2.run();
        System.out.println(vector);
    }

    public static void addA(Vector<Object> vector, String s) {
        if (!vector.contains("f1")) {
            vector.addElement(s);
        }
    }
}
