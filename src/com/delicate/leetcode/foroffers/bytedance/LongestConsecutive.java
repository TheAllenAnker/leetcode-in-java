package com.delicate.leetcode.foroffers.bytedance;

import java.util.HashSet;

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 6, 8, 2}));
        System.out.println(longestConsecutive(new int[]{-1, 0}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> seenSet = new HashSet<>();
        for (int num : nums) {
            seenSet.add(num);
        }

        int maxLen = 0;
        for (int num : nums) {
            if (!seenSet.contains(num - 1)) {
                int count = 1;
                for (int i = num + 1; seenSet.contains(i); i++) {
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}
