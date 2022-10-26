package com.hhnail.test;

public class ThrowTest {

    public static void main(String[] args) {
        System.out.println("报错前");
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("报错后");
    }
}
