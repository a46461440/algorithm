package com.zxc.algorithm.half;

import com.zxc.algorithm.sort.NSort;

/**
 * 二分法查询
 *
 * @author ZRM
 * @date 2019-09-14
 */
public class GetExactly {

    public int getExactly(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
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
        return -1;
    }

    public int getLastEq(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] == val) {
                if (middle == arr.length - 1) {
                    return middle;
                } else if (arr[middle + 1] == val) {
                    low = middle;
                } else if (arr[middle + 1] != val) {
                    return middle;
                }
            } else if (arr[middle] > val) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 3, 4, 4, 5, 5, 8, 8, 8, 10, 12, 14, 17};
        int index = new GetExactly().getLastEq(arr, 8);
        System.out.println(index);
    }

}
