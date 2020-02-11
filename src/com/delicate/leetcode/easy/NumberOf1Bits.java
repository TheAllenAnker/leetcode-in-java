package com.delicate.leetcode.easy;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }

    public static int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }
}
