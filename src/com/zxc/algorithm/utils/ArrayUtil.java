package com.zxc.algorithm.utils;

/**
 * 值交换工具
 *
 * @author ZRM
 * @date 2019-09-11
 */
public class ArrayUtil {

    public static void exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void move(int[] arr, int sourceIndex, int targetIndex, int size) {
        if (sourceIndex == targetIndex) return;
        for (int i = sourceIndex + size - 1; i >= sourceIndex; i--) {
            arr[targetIndex-- + size - 1] = arr[i];
        }
    }

}
