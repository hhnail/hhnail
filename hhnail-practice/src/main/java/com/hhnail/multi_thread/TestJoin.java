package com.hhnail.multi_thread;

/**
 * 测试join、可以理解为插队
 */
public class TestJoin implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        TestJoin target = new TestJoin();
        Thread thread = new Thread(target, "common user");

        thread.start();

        for (int i = 0; i < 50; i++) {
            if (i == 25) {
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + (i + 1) + " vip来咯，插队，，，");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            System.out.println(Thread.currentThread().getName() + (i + 1) + "正在排队。。。");

        }
    }
}
