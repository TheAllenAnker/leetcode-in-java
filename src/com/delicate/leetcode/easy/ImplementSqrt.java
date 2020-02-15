package com.delicate.leetcode.easy;

public class ImplementSqrt {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(mySqrt(i));
        }
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long num;
        int left = 2, right = x / 2, pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return right;
    }
}
