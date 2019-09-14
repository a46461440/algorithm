package com.zxc.algorithm.sort;

import com.zxc.algorithm.utils.ArrayUtil;

/**
 * 冒泡排序
 * 原地排序
 * 稳定排序
 * 空间复杂度O(1)
 * 最好时间复杂度O(n)
 * 最差时间复杂度O(n ^ 2)
 * 平均时间复杂度O(n ^ 2)
 *
 * @author ZRM
 * @date 2019-09-11
 */
public class BubbleSort {

    public void sort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            boolean flag = false; //这里进行了优化如果在一趟冒泡排序过后没有交换则已经有序
            for (int j = 0; j < size - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.exchange(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        new BubbleSort().sort(arr);
        System.out.println(arr);
    }

}
