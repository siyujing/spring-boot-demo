package com.testingedu.utilsdemo.线程间通信.方法一;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MethodOne {

    private ThreadToGo threadToGo = new ThreadToGo();


    public Runnable newThroadOne() {
        List<String> stringList = Lists.newArrayList("1", "2", "3", "4", "5");

        return new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < stringList.size(); i++) {
                        synchronized (threadToGo) {
                            while (threadToGo.value == 1) {
                                threadToGo.wait();
                            }
//                                System.out.println(stringList.get(i));
                            log.info("result = [{}]", stringList.get(i));
                            threadToGo.setValue(1);
                            threadToGo.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    log.info("thread one interrupt");
                }
            }
        };
    }

    public Runnable newThroadTwo() {
        List<String> stringList2 = Lists.newArrayList("A", "B", "C", "D", "E");

        return new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < stringList2.size(); i++) {
                        synchronized (threadToGo) {
                            while (threadToGo.value == 2) {
                                threadToGo.wait();
                            }
                            log.info("result = [{}]", stringList2.get(i));
                            threadToGo.setValue(2);
                            threadToGo.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    log.info("thread two interrupt");
                }
            }
        };
    }


    @Data
    class ThreadToGo {
        int value = 1;
    }
}
