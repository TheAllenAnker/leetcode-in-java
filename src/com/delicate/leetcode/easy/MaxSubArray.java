package com.delicate.leetcode.easy;

import java.util.Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Save result in-place
     *
     * @param nums input array
     * @return max sum of sub-array
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int length = nums.length;
        // calculate the sums ending at each index i and save the results in-place
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }

        // calculate the sums ending before each index i
        for (int i = 1; i < length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i]);
        }

        return nums[length - 1];
    }
}
