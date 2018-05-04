package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import org.springframework.stereotype.Service;

@Service
public class ThreadService {
    public static void main(String[] args) {
        ThreadA ta = new ThreadA();
        ThreadB tb = new ThreadB();
        ThreadC tc = new ThreadC();
        ThreadD td = new ThreadD();

        ta.setName("A");
        tb.setName("B");
        tc.setName("C");
        td.setName("D");

        ta.start();
        tb.start();
        tc.start();
        td.start();
    }
}
