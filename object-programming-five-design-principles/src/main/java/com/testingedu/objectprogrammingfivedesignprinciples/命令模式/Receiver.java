package com.testingedu.objectprogrammingfivedesignprinciples.命令模式;

import org.springframework.stereotype.Service;

/**
 * 行为的实现者，接受者类
 */
@Service
public class Receiver {
    /**
     * 指正执行命令逻辑的方法.接受者要执行的具体方法
     */
    public void action() {
        System.out.println("Receiver 执行具体的操作");
    }
}
