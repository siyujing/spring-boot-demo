package com.testingedu.utilsdemo.线程间通信.方法一;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class HelperHandler {
//    public List<String> list = new ArrayList<>();
//
//
//    public void setList(String str) {
//        list.add(str);
//    }
//
//    public List<String> getList() {
//        return list;
//    }

    private static final ExecutorService tPool = Executors.newFixedThreadPool(2);

    public void run(Runnable r){
        tPool.submit(r);
    }

}
