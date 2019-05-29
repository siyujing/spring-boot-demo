package com.testingedu.utilsdemo.MultiThread.lock_callable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by haibo on 2017/12/7.
 */
@Slf4j
public class CustomTaskNoLock<T> implements Callable {

    private Callable<T> callable;

    private String dbName;

    private String desc;


    private CustomTaskNoLock(Callable<T> callable, String dbName, String desc) {
        this.callable = Objects.requireNonNull(callable);
        this.dbName = dbName;
        this.desc = desc;
    }

    @SuppressWarnings("unchecked")
    public static <T> Callable<T> wrapCallableNoLock(Callable<T> callable, String dbName, String desc) {
        return new CustomTaskNoLock<>(callable, dbName, desc);
    }

    @Override
    public T call() throws Exception {
        StopWatch watch = new StopWatch();
        watch.start(desc);
        try {
            return callable.call();

        } finally {
            watch.stop();
            log.info("watch: {}", watch);
        }
    }

}
