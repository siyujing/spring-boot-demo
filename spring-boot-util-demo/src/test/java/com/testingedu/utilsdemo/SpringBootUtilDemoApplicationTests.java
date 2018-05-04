package com.testingedu.utilsdemo;

import com.testingedu.utilsdemo.MultiThread.synchrized_suo.NotifyNotifyAll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUtilDemoApplicationTests {

    @Autowired
    private NotifyNotifyAll notifyNotifyAll;

    @Test
    public void test() throws InterruptedException {
//        notifyNotifyAll.test();
//        Thread.sleep(10000);
    }

}
