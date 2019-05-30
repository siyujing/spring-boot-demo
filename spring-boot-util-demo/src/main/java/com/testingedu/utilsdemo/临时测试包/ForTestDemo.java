package com.testingedu.utilsdemo.临时测试包;


import java.util.ArrayList;

public class ForTestDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 50; i >= 1; i--) {
            int randomNumber = (int) Math.round(Math.random() * (50 - 1) + 1);
            System.out.println(randomNumber);
            list.add(randomNumber);
        }
        System.out.println(list);

    }
}
