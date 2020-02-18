package com.delicate.leetcode.easy;

public class PowerOfThree {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + isPowerOfThree(i));
        }
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
