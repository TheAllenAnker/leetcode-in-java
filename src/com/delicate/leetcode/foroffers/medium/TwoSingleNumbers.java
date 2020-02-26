package com.delicate.leetcode.foroffers.medium;

import java.util.Arrays;

public class TwoSingleNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumbers(new int[]{4, 1, 4, 6})));
        System.out.println(Arrays.toString(singleNumbers(new int[]{1, 2, 5, 2})));
    }

    public static int[] singleNumbers(int[] nums) {
        int ret = 0, a = 0, b = 0;
        for (int num : nums) {
            ret ^= num;
        }
        int highestOne = ret & -ret;
        for (int num : nums) {
            if ((num & highestOne) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
