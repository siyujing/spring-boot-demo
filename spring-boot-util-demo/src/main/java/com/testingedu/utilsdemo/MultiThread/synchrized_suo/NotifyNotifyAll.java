package com.testingedu.utilsdemo.MultiThread.synchrized_suo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotifyNotifyAll {

    private static final Object obj = new Object();

    private static class R implements Runnable {
        int i;

        public R(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (obj) {
                try {
                    log.info("线程 ->" + i + "在等待");
                    obj.wait();
                    for (int j = 0; j <= 3; j++) {
                        Thread.sleep(100);
                        log.info("线程 ->" + i + "开始运行");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new R(i));
        }
        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 唤醒所有等待的线程,必须使用同步代码块
        synchronized (obj) {
            obj.notifyAll();
        }
    }

}
