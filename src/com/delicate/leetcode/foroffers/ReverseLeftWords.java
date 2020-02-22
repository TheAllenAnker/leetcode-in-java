package com.delicate.leetcode.foroffers;

public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0) {
            return s;
        }

        int len = s.length();
        n %= len;
        if (n == 0) {
            return s;
        }

        String s1 = new StringBuilder(s.substring(0, n)).reverse().toString();
        String s2 = new StringBuilder(s.substring(n, len)).reverse().toString();
        return new StringBuilder(s1).append(s2).reverse().toString();
    }
}
