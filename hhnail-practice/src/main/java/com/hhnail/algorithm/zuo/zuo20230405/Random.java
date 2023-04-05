package com.hhnail.algorithm.zuo.zuo20230405;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 将不等概率且固定概率的0、1黑盒函数 转为 等概率的0、1函数
 * @date 2023/4/5 9:17
 */
public class Random {

    public static void main(String[] args) {

        int testTimes = 10000000;
        int count = 0;
        int k = 9;
        int[] arr = new int[k];
        for (int i = 0; i < testTimes; i++) {
            if (f1() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);



        System.out.println("=================== 华丽的分割线 ====================");


        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }

        System.out.println((double) count / (double) testTimes);

    }

    /**
     * 随机返回不等概率（但固定概率）0、1的函数
     * 这里出现0概率是p，出现1概率就是1-p
     *
     * @return
     */
    private static int f1() {
        return Math.random() < 0.88 ? 0 : 1;
    }


    /**
     * 调用两次f1，出现0，1或1、0的概率都是p*（1*p）
     * 出现0、0概率为p*p，出现1、1概率为（1-p）（1-p），概率不相等
     * 所以只要两次调用的结果不同，他们的概率就是相同的
     *
     * @return
     */
    private static int f2() {
        int random = 0;
        do {
            random = f1();
        } while (random == f1());
        return random;
    }

}
