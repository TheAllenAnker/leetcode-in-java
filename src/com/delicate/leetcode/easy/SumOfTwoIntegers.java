package com.delicate.leetcode.easy;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }

    public static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
