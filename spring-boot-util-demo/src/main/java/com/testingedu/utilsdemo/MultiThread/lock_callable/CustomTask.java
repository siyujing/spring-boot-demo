package com.testingedu.utilsdemo.MultiThread.lock_callable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by haibo on 2017/12/7.
 */
@Slf4j
public class CustomTask<T> implements Callable {

    private Callable<T> callable;

    private String dbName;

    private String desc;


    private CustomTask(Callable<T> callable, String dbName, String desc) {
        this.callable = Objects.requireNonNull(callable);
        this.dbName = dbName;
        this.desc = desc;
    }

    @SuppressWarnings("unchecked")
    public static <T> Callable<T> wrapCallable(Callable<T> callable, String dbName, String desc) {
        return new CustomTask<>(callable, dbName, desc);
    }

    @Override
    public T call() throws Exception {
        Lock lock = new ReentrantLock();
        StopWatch watch = new StopWatch();
        watch.start(desc);
        try {
            lock.lock();
            return callable.call();

        } finally {
            lock.unlock();
            watch.stop();
            log.info("watch: {}", watch);
        }
    }

}
