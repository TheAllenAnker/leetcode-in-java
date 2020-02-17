package com.delicate.leetcode.easy;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += (n / 5);
            n /= 5;
        }

        return count;
    }
}
