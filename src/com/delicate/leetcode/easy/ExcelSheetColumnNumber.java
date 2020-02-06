package com.delicate.leetcode.easy;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AZ"));
        System.out.println(titleToNumber("AAA"));
    }

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int magnitude = length - 1;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (magnitude == 0) {
                result += chars[i] - 'A' + 1;
            } else {
                result += (chars[i] - 'A' + 1) * ((int) Math.pow(26, magnitude));
            }
            magnitude--;
        }

        return result;
    }
}
