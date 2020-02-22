package com.delicate.leetcode.foroffers.easy;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        s = s.trim() + ' ';
        StringBuilder result = new StringBuilder();
        int start = 0, end = 1;
        int len = s.length();
        StringBuilder currWord;
        while (end < len) {
            if (s.charAt(end) == ' ') {
                currWord = new StringBuilder(s.substring(start, end));
                result.append(currWord.reverse().toString());
                if (end + 1 != len) {
                    result.append(' ');
                }
                end++;
                start = end;
                // jump through all the extra space
                for (int i = start; i < len; i++) {
                    if (s.charAt(i) == ' ') {
                        start++;
                    } else {
                        break;
                    }
                }
                end = start + 1;
                continue;
            }
            end++;
        }
        return result.reverse().toString();
    }
}
