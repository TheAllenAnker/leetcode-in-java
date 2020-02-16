package com.delicate.leetcode.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isAlphabetOrNumber(c)) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase().equals(sb.reverse().toString().toLowerCase());
    }

    private static boolean isAlphabetOrNumber(char c) {
        return ((int) c - 65 >= 0 && (int) c - 65 <= 25)
                || ((int) c - 97 >= 0 && (int) c - 97 <= 25)
                || ((int) c - 48 >= 0 && (int) c - 48 <= 9);
    }
}
