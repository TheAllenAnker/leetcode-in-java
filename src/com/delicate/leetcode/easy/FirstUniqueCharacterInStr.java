package com.delicate.leetcode.easy;

public class FirstUniqueCharacterInStr {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] nums = new int[26];
        for (char c : s.toCharArray()) {
            nums[c - 'a'] += 1;
        }
        int i = 0;
        for (char c : s.toCharArray()) {
            if (nums[c - 'a'] == 1) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
