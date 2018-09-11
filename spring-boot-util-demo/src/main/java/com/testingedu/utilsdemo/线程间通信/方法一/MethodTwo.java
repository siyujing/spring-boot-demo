package com.testingedu.utilsdemo.线程间通信.方法一;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * */

@Slf4j
@Service
public class MethodTwo {
     List<Integer> list = new ArrayList<>();


    public Runnable newThroadOne() {

        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (list) {
                        list.add(i);
                        log.info("add [{}]", i);
                    }
                }
            }
        };
    }

    public Runnable newThroadTwo() {
        return new Runnable() {
            @Override
            public void run() {
                try {

                    while (list.size() == 5) {
                        log.info("b 准备退出");
                        list.wait();
                        throw new InterruptedException();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
