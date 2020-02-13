package com.delicate.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sortedEnd = 1;
        int prevNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prevNum) {
                nums[sortedEnd] = nums[i];
                prevNum = nums[i];
                sortedEnd++;
            }
        }

        return sortedEnd;
    }
}
