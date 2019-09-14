package com.zxc.algorithm.sort;

import com.zxc.algorithm.utils.ArrayUtil;

/**
 * 插入排序
 * 原地排序
 * 稳定排序
 * 空间复杂度O(1)
 * 最好时间复杂度O(n) (在这个时候元素是逆序的)
 * 最差时间复杂度O(n ^ 2)
 * 平均时间复杂度O(n ^ 2)
 *
 * @author ZRM
 * @date 2019-09-11
 */
public class InsertSort {

    public void sort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (val < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        new InsertSort().sort(arr);
        System.out.println(arr);
    }

}