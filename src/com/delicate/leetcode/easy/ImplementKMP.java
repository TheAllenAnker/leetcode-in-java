package com.delicate.leetcode.easy;

import java.util.Arrays;

public class ImplementKMP {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("a", ""));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }

        int[] next = getNext(needle);
        // j indicates needle's current matching char
        int j = 0;
        // i never decrement
        for (int i = 0; i < haystack.length(); i++) {
            // if j's value back to zero again, start checking from the beginning of the pattern string
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // found needle in haystack
            if (j == needle.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }

    private static int[] getNext(String patternStr) {
        if (patternStr == null || patternStr.length() == 0) {
            return new int[]{};
        }

        int[] next = new int[patternStr.length()];
        for (int i = 1, k = 0; i < patternStr.length(); i++) {
            // find the longest matched prefix and postfix before index i
            while (k > 0 && patternStr.charAt(k) != patternStr.charAt(i)) {
                k = next[k - 1];
            }
            if (patternStr.charAt(k) == patternStr.charAt(i)) {
                k++;
            }
            next[i] = k;
        }

        return next;
    }
}
