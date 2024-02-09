package com.hhnail.multi_thread;

import com.hhnail.util.VvStringUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/5/20 13:20
 */
public class ThreadPoolTest {

    // 创建线程池并设置参数
    private int corePoolSize = 5;
    private int maxPoolSize = 10;
    private long keepAliveTime = 5000;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);


    public static void main(String[] args) {
        new ThreadPoolTest().myMain();
    }

    private void myMain() {
        long begin = System.currentTimeMillis();
        // 提交任务给线程池
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(() -> {
                // 执行相同任务
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程名：" + Thread.currentThread().getName());
            });
        }

        // 关闭线程池
        threadPoolExecutor.shutdown();
        long end = System.currentTimeMillis();

        System.out.println("多线程打印");
        System.out.println(end - begin);


        VvStringUtil.printSplitLine();

        begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("当前线程名：" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.currentTimeMillis();
        System.out.println("单线程打印");
        System.out.println(end - begin);
    }
}
