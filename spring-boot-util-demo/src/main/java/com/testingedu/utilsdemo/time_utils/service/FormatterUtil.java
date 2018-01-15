package com.testingedu.utilsdemo.time_utils.service;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;


@Service
public class FormatterUtil {

    public static void main(String[] args) {
        parseStingToDateTime();
    }

    public static void parseStingToDateTime(){
        String startTime = "2011-2-2 10:11:2";
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime startDate = DateTime.parse(startTime, dateTimeFormatter);
        System.out.println(startDate);
    }


}
