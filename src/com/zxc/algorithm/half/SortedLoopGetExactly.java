package com.zxc.algorithm.half;

/**
 * 有序循环数组求值
 * 二分法
 *
 * @author ZRM
 * @date 2019-09-14
 */
public class SortedLoopGetExactly {

    public int getExactly(int[] arr, int val) {
        if (arr[0] == val) {
            return 0;
        }
        if (arr[arr.length - 1] == val) {
            return arr.length - 1;
        }
        int point = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                point = i;
            }
        }
        if (arr[point] == val) {
            return point;
        }
        int low = 0;
        int high = 0;
        boolean flag = false;
        if (arr[point] > val && arr[0] < val) {
            flag = true;
            low = 0;
            high = point;
        } else if (arr[point + 1] < val && arr[arr.length - 1] > val) {
            flag = true;
            low = point + 1;
            high = arr.length - 1;
        }
        if (flag) {
            while (low <= high) {
                int middle = low + (high - low) / 2;
                if (arr[middle] == val) {
                    return middle;
                } else if (arr[middle] > val) {
                    high = middle;
                } else {
                    low = middle;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 1, 2, 3};
        int index = new SortedLoopGetExactly().getExactly(arr, 2);
        System.out.println(index);
    }

}
