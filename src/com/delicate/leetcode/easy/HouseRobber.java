package com.delicate.leetcode.easy;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int preMax = 0, currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(preMax + nums[i], currMax);
            preMax = temp;
        }

        return currMax;
    }
}
