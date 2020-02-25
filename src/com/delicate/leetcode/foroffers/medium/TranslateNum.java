package com.delicate.leetcode.foroffers.medium;

public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNum(506));
    }

    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }

        int pre = 1, curr = 1;
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int result = 0;
        for (int i = 1; i < len; i++) {
            char c = numStr.charAt(i);
            if (numStr.charAt(i - 1) == '0'
                    || (numStr.charAt(i - 1) == '2' && c >= '6')
                    || numStr.charAt(i - 1) >= '3') {
                result = curr;
            } else {
                result = curr + pre;
            }
            pre = curr;
            curr = result;
        }

        return result;
    }
}
