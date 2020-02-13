package com.delicate.leetcode.easy;

public class CountAndSay {
    public static void main(String[] args) {
        for (int i = 1; i < 7; i++) {
            System.out.println(countAndSay(i));
        }
    }

    public static String countAndSay(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Wrong Argument(s)");
        }
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        String result = "1";
        for (int i = 1; i < n; i++) {
            char prevChar = result.charAt(0);
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prevChar) {
                    count++;
                } else {
                    sb.append(count).append(prevChar);
                    prevChar = result.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(prevChar);
            result = sb.toString();
            sb = new StringBuilder();
        }

        return result;
    }
}
