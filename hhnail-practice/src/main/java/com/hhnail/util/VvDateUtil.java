package com.hhnail.util;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0
 * @description: 日期工具类
 * @date 2023/7/20 10:32
 */
public class VvDateUtil {


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // 设置年、月、日、时、分、秒
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        Date date1 = calendar.getTime();
        System.out.println(date1);

        calendar.clear();

        // 设置年、月、日、时、分、秒
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 20);
        calendar.set(Calendar.SECOND, 0);
        Date date2 = calendar.getTime();
        System.out.println(date2);

        System.out.println(earlier(date1, date2));


    }

    /**
     * 返回两个日期间较早的日期
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Date earlier(Date date1, Date date2) {

        if (date1 == null || date2 == null) {
            throw new RuntimeException("对比的日期不得为空");
        }

        // 将Date对象转换为LocalTime对象
        LocalTime localTime1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalTime localTime2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        return localTime1.isBefore(localTime2) ? date1 : date2;
    }
}
