package com.testingedu.utilsdemo.time_utils.service;

import java.time.LocalDate;

public class LocalTimeTest {
    public static void main(String[] args) {
        localDateTime();
    }

    public static void localDateTime(){
        LocalDate localDate = LocalDate.now();
        System.out.println("localhost:"+localDate); // localhost:2018-03-07
    }
}
