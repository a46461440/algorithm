package com.zxc.algorithm.sort;

import com.zxc.algorithm.utils.ArrayUtil;

/**
 * 归并排序
 * 稳定排序算法
 * 非原地排序
 * 时间复杂度O(nlogn)
 * 空间复杂度O(n) 因为每次合并完之后就被释放了
 *
 * @author ZRM
 * @date 2019-09-11
 */
public class MergeSort {

    public void sort(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        if (l == r - 1) {
            if (arr[l] > arr[r]) {
                ArrayUtil.exchange(arr, l, r);
            }
            return;
        }
        int middle = (l + r) / 2;
        sort(arr, l, middle);
        sort(arr, middle + 1, r);
        this.mergeArr(arr, l, middle, r);
    }

    public void mergeArr(int[] arr, int l, int middle, int r) {
        int insertIndex = l;
        int judgeIndex = middle + 1;
        while (insertIndex < r) {
            if (judgeIndex <= r && arr[judgeIndex] < arr[insertIndex]) {
                int temp = arr[judgeIndex];
                ArrayUtil.move(arr, insertIndex, insertIndex + 1, judgeIndex - insertIndex);
                arr[insertIndex] = temp;
                judgeIndex++;
            }
            insertIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        new MergeSort().sort(arr);
        System.out.println(arr);
    }

}
