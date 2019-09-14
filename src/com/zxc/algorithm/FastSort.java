package com.zxc.algorithm;

/**
 * 快速排序
 *
 * @author ZRM
 * @date 2019-08-24
 */
public class FastSort {

    public static void sort(int[] is) {
        sort2(is, 0, is.length - 1);
    }

    private static void sort(int[] is, int first, int last) {
        if (first == last) {
            return;
        } else if (first + 1 == last) {
            if (is[first] > is[last]) {
                exchange(is, first, last);
                return;
            }
        } else {
            int standard = first;
            int small = first + 1;
            int big = last;
            while (small + 1 < big) {
                while (is[big] > is[standard]) {
                    big--;
                }
                while (is[small] <= is[standard]) {
                    small++;
                }
                exchange(is, small, big);
            }
            exchange(is, small, standard);
            sort(is, first, small - 1);
            sort(is, big, last);
        }
    }

    private static void sort2(int[] is, int first, int last) {
        if (first == last) {
            return;
        } else if (first + 1 == last) {
            if (is[first] > is[last]) {
                exchange(is, first, last);
                return;
            }
        } else {
            int standard = first;
            int small = first + 1;
            int equal = first + 1;
            int big = last;
            while (equal + 1 < big) {
                while (is[big] > is[standard]) {
                    big--;
                }
                while (is[small] < is[standard]) {
                    exchange(is, small, equal);
                    small++;
                    equal++;
                }
                while (is[small] == is[standard]) {
                    equal++;
                    small++;
                }
                exchange(is, small, big);
            }
            exchange(is, small, standard);
            sort2(is, first, equal - 1);
            sort2(is, big, last);
        }
    }

    private static void exchange(int[] is, int one, int two) {
        int temp = is[one];
        is[one] = is[two];
        is[two] = temp;
    }

    public static void main(String[] args) {
        int[] is = new int[]{2, 3, 3, 6, 3, 1, 6, 4, 9, 6, 3, 4};
        sort(is);
        System.out.println(is);
    }

}
