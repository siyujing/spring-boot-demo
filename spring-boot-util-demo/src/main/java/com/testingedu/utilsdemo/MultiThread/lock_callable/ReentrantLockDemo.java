package com.testingedu.utilsdemo.MultiThread.lock_callable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.testingedu.utilsdemo.MultiThread.lock_callable.CustomTask.wrapCallable;
import static com.testingedu.utilsdemo.MultiThread.lock_callable.CustomTaskNoLock.wrapCallableNoLock;

@Service
@Slf4j
public class ReentrantLockDemo {

    static volatile Long a = 0L;
    static volatile Long b = 0L;

    public void reentrantLockDemo() throws ExecutionException, InterruptedException {
        ExecutorService customExecutor = Executors.newFixedThreadPool(4);
        Future<Long> testUser = customExecutor.submit(wrapCallable(this::method, "bebase", "线程1"));
        Future<Long> testUser2 = customExecutor.submit(wrapCallable(this::method2, "bebase2", "线程2"));
        Future<Long> testUser3 = customExecutor.submit(wrapCallableNoLock(this::method3, "bebase3", "线程3"));
        Future<Long> testUser4 = customExecutor.submit(wrapCallableNoLock(this::method4, "bebase4", "线程4"));

        System.out.println("testUser1=" + testUser.get());
        System.out.println("testUser2=" + testUser2.get());

        System.out.println("testUser3=" + testUser3.get());
        System.out.println("testUser4=" + testUser4.get());
    }

    public Long method() {
        log.info("开始执行方法1..........");
        for (int i = 0; i <= 100000; i++) {
            ++a;
        }
        log.info("a=" + a);
        return a;
    }

    public Long method2() {
        log.info("开始执行方法2..........");
        log.info("b=" + (a + b));
        return a + b;
    }

    public Long method3() {
        log.info("开始执行方法3..........");
        log.info("b=" + (a + b));
        return a + b;
    }

    public Long method4() {
        log.info("开始执行方法4..........");
        log.info("b=" + (a + b));
        return a + b;
    }
}
