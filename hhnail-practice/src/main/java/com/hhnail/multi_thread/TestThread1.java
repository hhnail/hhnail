package com.hhnail.multi_thread;

/**
 * 学习：多线程
 * @Date:2022-07-09
 * https://www.bilibili.com/video/BV1V4411p7EF?p=7&spm_id_from=333.1007.top_right_bar_window_history.content.click&vd_source=474ab86db8305b8c70c50a020bcdf556
 */
public class TestThread1 implements Runnable {

    int ticketNum = 20;

    public static void main(String[] args) {
        TestThread1 thread1 = new TestThread1();
        // 代理模式
        new Thread(thread1, "zhangsan").start();
        new Thread(thread1, "lisi").start();
        new Thread(thread1, "wangwu").start();

    }

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    String.format("抢票啦， %s 抢到第 %s 张",
                            Thread.currentThread().getName(),
                            ticketNum--)
            );
        }
    }
}
