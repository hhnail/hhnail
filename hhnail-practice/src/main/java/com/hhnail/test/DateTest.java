package com.hhnail.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        String mTime = new SimpleDateFormat("HHmmss").format(new Date());
        System.out.println(mTime);
    }
}
