package com.delicate.leetcode.foroffers.bytedance;

public class FindLengthOfLCIS {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                count++;
            } else {
                maxLen = Math.max(maxLen, count);
                count = 1;
            }
            prev = nums[i];
        }
        return Math.max(count, maxLen);
    }
}
