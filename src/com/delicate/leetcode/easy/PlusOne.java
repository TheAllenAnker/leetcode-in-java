package com.delicate.leetcode.easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 9};
        System.out.println(Arrays.toString(plusOne(nums1)));
        int[] nums2 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums2)));
        int[] nums3 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(nums3)));
    }

    public static int[] plusOne(int[] digits) {
        // modify the array in place
        int length = digits.length;
        int carry = digits[length - 1] == 9 ? 1 : 0;
        digits[length - 1] = carry == 1 ? 0 : digits[length - 1] + 1;
        for (int i = length - 2; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] == 10 ? 1 : 0;
            digits[i] = digits[i] == 10 ? 0 : digits[i];
        }
        if (carry == 1) {
            int[] result = new int[length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, length);
            digits = result;
        }

        return digits;
    }
}
