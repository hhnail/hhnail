package com.hhnail.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    @Test
    public void test01() {
        String mTime = new SimpleDateFormat("HHmmss").format(new Date());
        System.out.println(mTime);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Test
    public void test02() {
        Date lastDay = getLastDayOfMonth(new Date());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("last_Day_Of_Month = " + df.format(lastDay));
    }

    /**
     * 获取某date的月份的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int lastDay = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        return calendar.getTime();
    }

    @Test
    public void test03() {


        System.out.println(Calendar.getInstance().getActualMaximum(Calendar.DATE));

    }

    @Test
    public void test04() {

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date())
        );

    }

}
