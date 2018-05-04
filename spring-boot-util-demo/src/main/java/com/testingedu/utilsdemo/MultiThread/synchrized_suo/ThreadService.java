package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import org.springframework.stereotype.Service;

@Service
public class ThreadService {
    public static void main(String[] args) {
        ThreadA ta = new ThreadA();
        ThreadB tb = new ThreadB();
        ThreadC tc = new ThreadC();
        ThreadC2 tc2 = new ThreadC2();
        ThreadD td = new ThreadD();

        ta.setName("A");
        tb.setName("B");
        tc.setName("C1");
        tc2.setName("C2");
        td.setName("D");

        ta.start();
        tb.start();
        tc.start();
        tc2.start();
        td.start();
    }
}
