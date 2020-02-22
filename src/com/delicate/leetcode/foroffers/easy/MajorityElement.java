package com.delicate.leetcode.foroffers.easy;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(majorityElement(new int[]{6, 5, 5}));
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int result = nums[0];
        int count = 1;
        for (int num : nums) {
            if (num == result) {
                count++;
            } else {
                if (count == 1) {
                    result = num;
                } else {
                    count--;
                }
            }
        }

        return result;
    }
}
