package com.testingedu.utilsdemo.time_utils.service;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@Service
public class TimeFormatterUtil {

    public static void main(String[] args) {
        parseStingToDateTime();
    }

    public static void parseStingToDateTime() {
        String startTime = "2011-2-2 10:11:2";
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime startDate = DateTime.parse(startTime, dateTimeFormatter);
        System.out.println("startDate=" + startDate);         // startDate=2011-02-02T10:11:02.000+08:00

        String concat = startTime.concat("asd");
        System.out.println("concat=" + concat);               // concat=2011-2-2 10:11:2asd

        boolean afterNow = startDate.isAfterNow();
        System.out.println("afterNow=" + afterNow);           // afterNow=false

        DateTime.Property dayOfMonth = startDate.dayOfMonth();
        String dayOfMonthAsString = dayOfMonth.getAsString();
        System.out.println("dayOfMonthAsString=" + dayOfMonthAsString);       // dayOfMonthAsString=2

        DateTime dateTime = new DateTime();
        DateTime.Property property = dateTime.millisOfSecond();
        System.out.println("result=" + property.getAsString());               // result=650

        System.out.println(dateTime.toLocalDate());                         // 2018-06-08
        System.out.println(dateTime.toLocalDateTime());                     // 2018-06-08T11:09:43.543
        System.out.println(dateTime.toLocalTime());                         // 11:09:43.543
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));       // 2018-06-08 11:09:43

        // 时间戳不显示毫秒
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());        // timestamp = 2018-09-19 11:12:52.662
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(timestamp);                                      // str = 2018-09-19 11:12:52

        System.out.println(str);

    }


}
