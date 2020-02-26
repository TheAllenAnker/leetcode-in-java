package com.delicate.leetcode.foroffers.medium;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("  "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("add"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> records = new HashMap<>();
        int len = s.length(), ans = 0;
        for (int i = 0, j = 0; j < len; j++) {
            char c = s.charAt(j);
            if (records.containsKey(c)) {
                i = Math.max(records.get(c), i);
            }
            ans = Math.max(ans, j - i + 1);
            records.put(c, j + 1);
        }
        return ans;
    }
}
