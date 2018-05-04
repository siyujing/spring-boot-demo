package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import org.springframework.stereotype.Service;

@Service
public class ThreadD extends Thread {

    private Tasks tasks = new Tasks();

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            tasks.doTaskD();
        }
    }
}
