package com.delicate.leetcode.foroffers;

import java.util.Arrays;

public class IsStraight {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(isStraight(new int[]{11, 0, 9, 0, 0}));
    }

    public static boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) {
            throw new IllegalArgumentException();
        }

        int misplaces = 0;
        int filling = 0;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum == 0) {
                filling++;
            } else {
                if (prev == currNum) {
                    return false;
                }
                if (prev != 0) {
                    misplaces += currNum - prev - 1;
                }
                prev = currNum;
            }
        }
        return filling >= misplaces;
    }
}
