package com.testingedu.utilsdemo.time_utils.service;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class TimeStampUtil {
    public static void main(String[] args) throws ParseException {
        getEndTimeYesterday();
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

    public static LocalDate getYesterday() {
        return LocalDate.now().minusDays(1);
    }

    // 获取当天开始时间的时间戳
    public static Long getStartTimeToday() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        System.out.println("1:"+todayStart.getTime());      // 1:Wed Mar 07 00:00:00 CST 2018
        System.out.println("2:"+todayStart.getTime().getTime());         // 2:1520352000000
        return todayStart.getTime().getTime();
    }

    // 获取当天结束时间的时间戳
    public static Long getEndTimeToday() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        System.out.println("1todayEnd:"+todayEnd.getTime());        // 1todayEnd:Wed Mar 07 23:59:59 CST 2018
        System.out.println("2todayEnd:"+todayEnd.getTime().getTime());      // 2todayEnd:1520438399999
        return todayEnd.getTime().getTime();
    }

    public static DateTime getStartTimeYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new DateTime(calendar.getTime());
    }

    public static DateTime getEndTimeYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println("1calendar:"+calendar.getTime());        // 1calendar:Wed Mar 07 00:00:00 CST 2018
        System.out.println("2calendar:"+calendar.getTime().getTime());      // 2calendar:1520352000000
        return new DateTime(calendar.getTime());
    }
}
