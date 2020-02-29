package com.delicate.leetcode.foroffers.bytedance;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {1, 2, 3};
        for (int i = 0; i < 4; i++) {
            np.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
        int[] nums2 = {1, 1, 5};
        np.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int currIndex = len - 2;
        int currNum = nums[currIndex + 1];
        while (currIndex >= 0 && nums[currIndex] >= currNum) {
            currNum = nums[currIndex];
            currIndex--;
        }

        if (currIndex != -1) {
            int j = currIndex + 1;
            while (j + 1 < len && nums[j + 1] > nums[currIndex]) {
                j++;
            }
            swap(nums, currIndex, j);
        }

        reverse(nums, currIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (start < 0 || end >= nums.length || start >= end) {
            return;
        }

        int i = start, j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        if (i < 0 || i >= len || j < 0 || j >= len) {
            return;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
