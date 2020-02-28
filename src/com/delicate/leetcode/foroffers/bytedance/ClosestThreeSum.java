package com.delicate.leetcode.foroffers.bytedance;

import java.util.Arrays;

public class ClosestThreeSum {
    public static void main(String[] args) {
        System.out.println(closestThreeSum(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int closestThreeSum(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(closest - target);
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1, end = len - 1;
            while (start < end) {
                int currNum = nums[start] + nums[end] + nums[i];
                int currDiff = Math.abs(currNum - target);
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    closest = currNum;
                }
                if (currNum < target) {
                    start++;
                } else if (currNum == target) {
                    return target;
                } else {
                    end--;
                }
            }
        }
        return closest;
    }
}
