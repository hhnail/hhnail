package com.hhnail.algorithm.zuo.zuo20230405;

import com.hhnail.util.HArrayUtil;

/**
 * @author Hhnail
 * @version 1.0
 * @description: 局部最小值
 * @date 2023/4/5 10:02
 */
public class LocalMin {


    public static void main(String[] args) {
        // 返回一个局部最小值（可能存在多个，返回一个即可）
        // int[] array = getArray();
        int[] array = getRandomArray(10, 100);
        HArrayUtil.printIntArr(array);
        int localMinIndex = getLocalMin(array);
        System.out.println(localMinIndex);
        System.out.println(array[localMinIndex]);

    }

    /**
     * 获取局部最小值的下标
     *
     * @param array
     * @return
     */
    private static int getLocalMin(int[] array) {
        int length = array.length;
        if (length < 1) {
            return -1;
        }
        if (length == 1) {
            return 0;
        }
        if (array[0] < array[1]) {
            return 0;
        }
        if (array[length - 1] < array[length - 2]) {
            return length - 1;
        }
        int l = 0;
        int r = length - 1;
        int localMinIndex = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midValue = array[mid];
            int leftValue = array[mid - 1];
            int rightValue = array[mid + 1];
            if (midValue < rightValue && midValue < leftValue) {
                localMinIndex = mid;
                break;
            } else if (midValue > rightValue) {
                l = mid;
            } else if (midValue > leftValue) {
                r = mid;
            }
        }
        return localMinIndex;
    }


    /**
     * 返回随机数组
     * 数组的值无序，但是相邻的值必然不相等
     *
     * @return
     */
    private static int[] getArray() {
        // return new int[]{9, 1, 3, 1, 45, 23, 12, 7, 5, 6, 88, 99};
        return new int[]{30, 78, 5, 35, 46, 93, 57};
        // return new int[]{9, 1, 3, 8, 10, 11, 12, 13, 17, 19, 21, 99};
        // return new int[]{33};

    }



    /**
     * 返回随机数组
     * 数组的值无序，但是相邻的值必然不相等
     *
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] arr = new int[len];
        if (len > 0) {
            if (len > 0) {
                arr[0] = (int) (Math.random() * maxValue);
                for (int i = 1; i < len; i++) {
                    do {
                        arr[i] = (int) (Math.random() * maxValue);
                    } while (arr[i] == arr[i - 1]);
                }
            }
        }
        return arr;
    }



    /**
     * 用于校验是否局部最小（小于右边也小于左边）
     */
    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

}
