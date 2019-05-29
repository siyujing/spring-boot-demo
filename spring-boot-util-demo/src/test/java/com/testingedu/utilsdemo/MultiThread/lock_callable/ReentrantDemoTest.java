package com.testingedu.utilsdemo.MultiThread.lock_callable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReentrantDemoTest {
    @Autowired
    private ReentrantLockDemo reentrantLockDemo;


    @Test
    public void reentrantLockDemo() throws ExecutionException, InterruptedException {
        reentrantLockDemo.reentrantLockDemo();
    }
}
