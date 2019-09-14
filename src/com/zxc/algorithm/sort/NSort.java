package com.zxc.algorithm.sort;

/**
 * 计数排序
 *
 * @author ZRM
 * @date 2019-09-13
 */
public class NSort {
    public void countingSort(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) max = arr[i];
        }
        int[] bucketArr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            bucketArr[arr[i]]++;
        }
        for (int i = 1; i < max + 1; i++) {
            bucketArr[i] += bucketArr[i - 1];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int index = bucketArr[arr[i]]-- - 1;
            result[index] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }

    public void countingSort2(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) max = arr[i];
        }
        int[] bucketArr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            bucketArr[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < max + 1; i++) {
            int j = bucketArr[i];
            if (j > 0) {
                while (j-- > 0) {
                    arr[index++] = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 7, 2, 5, 10, 10, 9};
        new NSort().countingSort2(arr);
        System.out.println(arr);
    }
}
