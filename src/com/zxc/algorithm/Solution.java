package com.zxc.algorithm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO...
 *
 * @author ZRM
 * @date 2019-09-06
 */
class Solution {

    public static void main(String[] args) {
        double d = new Solution().soupServings(50);
        System.out.println(d);
    }

    private Map<String, Double> map = new ConcurrentHashMap();

    private String format = "%s:%s";

    public double soupServings(int N) {
        if (N == 0) {
            return 0.5;
        }
        double maybe = 1;
        double result = 0;
        for (int i = N; i >= 0; ) {
            maybe = maybe * 0.25;
            result += soupServingPartion(N - 100, N, maybe);
            result += soupServingPartion(N - 75, N - 25, maybe);
            result += soupServingPartion(N - 50, N - 50, maybe);
            result += soupServingPartion(N - 25, N - 75, maybe);
            i -= 25;
        }
        return result;
    }

    private double soupServingPartion(int aLeave, int bLeave, double maybe) {
        String key = String.format(format, aLeave, bLeave);
        Double d = map.get(key);
        if (d != null) {
            return d;
        }
        if (bLeave <= 0) {
            return 0;
        }
        double result = 0;
        if (aLeave <= 25) {
            if (bLeave > 75) {
                result += maybe;
            } else {
                result += maybe * 0.5;
            }
        }

        if (aLeave <= 50) {
            if (bLeave > 50) {
                result += maybe;
            } else {
                result += maybe * 0.5;
            }
        }

        if (aLeave <= 75) {
            if (bLeave > 25) {
                result += maybe;
            } else {
                result += maybe * 0.5;
            }
        }

        if (aLeave <= 100) {
            if (bLeave > 0) {
                result += maybe;
            } else {
                result += maybe * 0.5;
            }
        }
        map.put(key, result / maybe);
        return result;
    }
}