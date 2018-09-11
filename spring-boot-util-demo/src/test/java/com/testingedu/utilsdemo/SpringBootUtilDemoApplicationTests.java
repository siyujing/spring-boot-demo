package com.testingedu.utilsdemo;

import com.testingedu.utilsdemo.MultiThread.synchrized_suo.NotifyNotifyAll;
import com.testingedu.utilsdemo.线程间通信.方法一.MethodOne;
import com.testingedu.utilsdemo.线程间通信.方法一.MethodTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUtilDemoApplicationTests {

    @Autowired
    private MethodTwo methodTwo;

    @Test
    public void test() {
        final Runnable runnable1 = methodTwo.newThroadOne();
        final Runnable runnable2 = methodTwo.newThroadTwo();
        Thread thread = new Thread(runnable1);
        thread.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }

}
