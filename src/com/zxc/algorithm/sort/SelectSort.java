package com.zxc.algorithm.sort;

import com.zxc.algorithm.utils.ArrayUtil;

/**
 * 选择排序
 * 原地排序
 * 非稳定排序
 * 空间复杂度O(1)
 * 最好时间复杂度O(n)
 * 最差时间复杂度O(n ^ 2)
 * 平均时间复杂度O(n ^ 2)
 *
 * @author ZRM
 * @date 2019-09-11
 */
public class SelectSort {

    public void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int minIndex = i + 1;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayUtil.exchange(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        new SelectSort().sort(arr);
        System.out.println(arr);
    }

}
