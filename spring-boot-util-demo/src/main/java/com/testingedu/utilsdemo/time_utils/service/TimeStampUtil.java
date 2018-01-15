package com.testingedu.utilsdemo.time_utils.service;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class TimeStampUtil {
    public static void main(String[] args) throws ParseException {
        timeStamps();
    }

    public static void timeStamps() throws ParseException {
        long timeStamp = System.currentTimeMillis();
        System.out.println(timeStamp);          // 1515985082392

        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(timeStamp);
        System.out.println(d);                    // d = 2018-01-15 10:58:02
        System.out.println(format.parse(d));      // Mon Jan 15 10:58:02 CST 2018

        System.out.println(DateTime.now());
    }
}
