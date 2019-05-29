package com.testingedu.utilsdemo.MultiThread.lock_callable.web;

import com.testingedu.utilsdemo.MultiThread.lock_callable.ReentrantLockDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReentrantLockDemoController {

    @Autowired
    ReentrantLockDemo reentrantLockDemo;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object e() {
        try {
            reentrantLockDemo.reentrantLockDemo();
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
