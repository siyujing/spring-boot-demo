package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;

import org.springframework.stereotype.Service;

import java.io.Console;
import java.io.PrintWriter;

// 上午状态
@Service
public class SleepingState extends State {

    @Override
    public void writeProject(Work work) {
        System.out.println("当前"+work.getHour()+" 点，不行了，睡着了。。。");
    }

    public static void main(String[] args) {
        Console console = System.console();
        String uuu = console.readLine("uuu");
        console.printf(uuu);
        System.out.println(console);
//        console.printf("当前{0} 点，不行了，睡着了。。。", "0");
    }
}
