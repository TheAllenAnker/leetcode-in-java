package com.delicate.leetcode.easy;

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        String input = x + "";
        char[] digits = x > 0 ? input.toCharArray() : (x + "").substring(1, input.length()).toCharArray();
        StringBuilder sb = new StringBuilder();
        if (digits.length != input.length()) {
            sb.append("-");
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        int result;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return result;
    }
}
