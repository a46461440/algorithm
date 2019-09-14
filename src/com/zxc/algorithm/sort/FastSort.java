package com.zxc.algorithm.sort;

import com.zxc.algorithm.utils.ArrayUtil;

import java.util.Stack;

/**
 * 快速排序
 * 原地排序
 * 最好时间复杂度O(nlogn)
 * 最差时间复杂度O(n ^ 2)
 * 平均时间复杂度O(nlogn)
 *
 * @author ZRM
 * @date 2019-09-11
 */
public class FastSort {

    public void sort(int[] arr) {
//        this.sort(arr, 0, arr.length - 1);
        int l = 0;
        int r = arr.length - 1;
        Stack<int[]> stack = new Stack();
        stack.push(new int[]{l, r});
        while (!stack.empty()) {
            int[] indexArr = stack.pop();
            int currentIndex = this.sort(arr, indexArr[0], indexArr[1]);
            if (currentIndex >= 0) {
                stack.push(new int[]{indexArr[0], currentIndex});
                stack.push(new int[]{currentIndex + 1, indexArr[1]});
            }
        }
    }

    private int sort(int[] arr, int l, int r) {
        int size = r - l;
        if (size > 2) {
            int val = arr[r];
            int currentIndex = l;
            for (int i = l; i < r; i++) {
                if (arr[i] < val) {
                    ArrayUtil.exchange(arr, i, currentIndex);
                    currentIndex++;
                }
            }
            ArrayUtil.exchange(arr, r, currentIndex);
//            sort(arr, l, currentIndex);
//            sort(arr, currentIndex + 1, r);
            return currentIndex;
        } else if (size == 2) {
            if (arr[l] > arr[l + 1]) {
                ArrayUtil.exchange(arr, l, l + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        new FastSort().sort(arr);
        System.out.println(arr);
    }

}
