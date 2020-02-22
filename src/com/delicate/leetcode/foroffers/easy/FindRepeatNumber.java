package com.delicate.leetcode.foroffers.easy;

import java.util.HashSet;

public class FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public static int findRepeatNumber(int[] nums) {
        int[] records = new int[nums.length];
        for (int num : nums) {
            if (records[num] == 1) {
                return num;
            }
            records[num] = 1;
        }
        return 0;
    }
}
