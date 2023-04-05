package com.hhnail.algorithm.zuo.zou20230403;

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


        System.out.println("=================== 华丽的分割线 ====================");
        k = 7;
        testTimes = 700000;
        arr = new int[k];
        for (int i = 0; i < testTimes; i++) {
            arr[f3()]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + "出现的次数为：" + arr[i]);
        }

        System.out.println("=================== 华丽的分割线 ====================");
        k = 7;
        testTimes = 700000;
        arr = new int[k];
        for (int i = 0; i < testTimes; i++) {
            int random = f4();
            // System.out.println(random);
            arr[random - 1]++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(i + 1 + "出现的次数为：" + arr[i]);
        }

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


    // 随机0、1——>随机0~6的整数
    private static int f3() {
        int r1 = f2() << 2;
        int r2 = f2() << 1;
        int r3 = f2() << 0;
        int random = r1 + r2 + r3;
        if (random == 7) {
            return f3();
        }
        return random;
    }

    // 随机0、1——>随机1~7的整数
    private static int f4() {
        return f3() + 1;
    }


}
