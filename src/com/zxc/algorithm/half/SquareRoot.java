package com.zxc.algorithm.half;

/**
 * 求一个数的平方根
 * 使用二分法
 *
 * @author ZRM
 * @date 2019-09-13
 */
public class SquareRoot {

    public double getSquare(double n) {
        double high = 5;
        double low = 0;
        double middle = 0;
        while (Math.abs(high - low) > 1e-6) {
            middle = low + (high - low) / 2;
            double temp = middle * middle;
            if (temp == n) {
                return middle;
            } else if (temp > n) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        double d = new SquareRoot().getSquare(5);
        System.out.println(d);
    }

}
