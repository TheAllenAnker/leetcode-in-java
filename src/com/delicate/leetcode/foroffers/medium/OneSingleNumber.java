package com.delicate.leetcode.foroffers.medium;

public class OneSingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3, 4, 3, 3}));
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((1 << i) & num) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
