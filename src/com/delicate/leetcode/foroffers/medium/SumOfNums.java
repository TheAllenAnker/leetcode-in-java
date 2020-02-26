package com.delicate.leetcode.foroffers.medium;

public class SumOfNums {
    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }

    public static int sumNums(int n) {
        int result = 0;
        boolean flag = n > 0 && (result = n + sumNums(n - 1)) > 0;
        return result;
    }
}
