package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ThreadC extends Thread {

    private Tasks tasks = new Tasks();

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            tasks.doTaskC();
        }
    }
}
