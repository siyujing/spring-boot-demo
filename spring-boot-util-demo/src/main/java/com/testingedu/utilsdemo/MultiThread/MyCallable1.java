package com.testingedu.utilsdemo.MultiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class MyCallable1 {


    public static void main(String[] args) {

        MyCallable1 th = new MyCallable1();

//      使用Lambda表达式创建Callable对象
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i=0;i<=10;i++){
                log.debug("test="+i);
                }
                return 55;
            }
        };

//      使用FutureTask类来包装Callable对象
        FutureTask<Integer> future = new FutureTask<Integer>(callable);

        new Thread(future, "有返回值的线程,此处是线程的名称").start();//实质上还是以Callable对象来创建并启动线程

        try {
            System.out.println("子线程的返回值：" + future.get());//get()方法会阻塞，直到子线程方法执行结束才返回
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
