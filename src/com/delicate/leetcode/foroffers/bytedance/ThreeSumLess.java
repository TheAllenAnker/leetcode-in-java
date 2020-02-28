package com.delicate.leetcode.foroffers.bytedance;

import java.util.Arrays;

public class ThreeSumLess {
    public static void main(String[] args) {
        System.out.println(threeSumLess(new int[]{-2, 0, 1, 3}, 2));
    }

    public static int threeSumLess(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            int num1 = nums[i];
            if (num1 >= target && num1 >= 0) break;
            int left = i + 1, right = len - 1;
            while (left < right) {
                int currSum = num1 + nums[left] + nums[right];
                if (currSum < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
