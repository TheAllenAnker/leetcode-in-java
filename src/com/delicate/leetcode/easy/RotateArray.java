package com.delicate.leetcode.easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums == null || nums.length == 0 || k < 0) {
            throw new IllegalArgumentException();
        }

        int len = nums.length;
        if (k % len == 0) {
            return;
        }
        k = k > len ? k % len : k;
        reverseArr(nums, 0, len - k - 1);
        reverseArr(nums, len - k, len - 1);
        reverseArr(nums, 0, len - 1);
    }

    private static void reverseArr(int[] nums, int from, int to) {
        if (from >= to || nums == null || nums.length == 0 || from < 0 || to >= nums.length) {
            return;
        }
        int temp;
        while (from < to) {
            temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }
}
