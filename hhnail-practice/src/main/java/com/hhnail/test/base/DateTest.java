package com.hhnail.test.base;

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

    @Test
    public void test05() {
        System.out.println(new Date().getTime());

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(1672803869244L))
        );
    }


    @Test
    public void test06() throws Exception{
        // System.out.println(("P1201010067" + new Date().getTime()).length());
        // System.out.println(("P1201010067-" + new Date().getTime()));
        // System.out.println(("P1201010067-" + new Date().getTime()));
        // Thread.sleep(1*1000);
        // System.out.println(("P1201010067-" + new Date().getTime()));
        // System.out.println(("P1101010080-1672898630721".length()));
        //
        // System.out.println(("P1201010067-" + new Date().getTime()));
        // System.out.println(("P1201010067-" + new Date().getTime()));


        System.out.println(new Date().getTime());
        System.out.println(new Date("2023-01-04 15:21:00").getTime());


    }

}
