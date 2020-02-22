package com.delicate.leetcode.foroffers.easy;

import java.util.Arrays;

public class PrintNumbers {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(printNumbers(i)));
        }
    }

    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return null;
        }

        StringBuilder maxStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            maxStr.append('9');
        }
        int max = Integer.parseInt(maxStr.toString());
        int[] nums = new int[max];
        for (int i = 0; i < max; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
