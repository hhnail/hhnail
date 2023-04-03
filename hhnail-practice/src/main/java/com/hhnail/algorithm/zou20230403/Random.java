package com.hhnail.algorithm.zou20230403;

import java.util.Timer;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 随机。给你一个黑盒随机出现[1,2,3,4,5]的函数f1。如何得到一个1~7的函数
 * @date 2023/4/3 20:29
 */
public class Random {
    public static void main(String[] args) {
        int testTimes = 10000000;
        int count = 0;
        int k = 9;
        int[] arr = new int[k];
        for (int i = 0; i < testTimes; i++) {
            arr[f1()]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "出现的次数为：" + arr[i]);
        }

        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f1() < 3) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) 2 / (double) 4);

        System.out.println("=================== 华丽的分割线 ====================");


        count = 0;
        int count2 = 0;
        for (int i = 0; i < testTimes; i++) {
            if ((double) f2() < 0.5d) {
                count++;
            }
            if ((double) f2v2() < 0.5d) {
                count2++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double) count2 / (double) testTimes);

    }

    // 随机1、2、3、4、5
    private static int f1() {
        // 5点多转int是5
        return (int) (5 * Math.random()) + 1;
    }

    // 将随机1、2、3、4、5 ———> 随机0、1。写法1：if
    private static int f2() {
        int random = f1();
        if (random == 3) {
            return f2();
        }
        return random < 3 ? 0 : 1;
    }

    // 将随机1、2、3、4、5 ———> 随机0、1。写法2：while
    private static int f2v2() {
        int random = 0;
        do {
            random = f1();
        } while (random == 3);
        return random < 3 ? 0 : 1;
    }


}
