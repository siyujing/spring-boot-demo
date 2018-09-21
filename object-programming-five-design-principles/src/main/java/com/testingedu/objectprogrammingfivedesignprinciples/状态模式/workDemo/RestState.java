package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;

import org.springframework.stereotype.Service;

@Service
public class RestState extends State {
    @Override
    public void writeProject(Work work) {
        System.out.println("当前时间"+work.getHour()+" 下班了");
    }
}
