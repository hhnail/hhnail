package com.hhnail.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        String mTime = new SimpleDateFormat("HHmmss").format(new Date());
        System.out.println(mTime);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
