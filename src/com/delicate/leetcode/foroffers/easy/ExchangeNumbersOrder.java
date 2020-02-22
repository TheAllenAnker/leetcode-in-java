package com.delicate.leetcode.foroffers.easy;

import java.util.Arrays;

public class ExchangeNumbersOrder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }

    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int even = 0, odd = nums.length - 1;
        while (even < odd) {
            while (even < nums.length && nums[even] % 2 != 0) {
                even++;
            }
            while (odd >= 0 && nums[odd] % 2 == 0) {
                odd--;
            }
            if (even < odd) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }
}
