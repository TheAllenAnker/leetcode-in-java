package com.delicate.leetcode.foroffers.medium;

public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber("96 e5"));
        System.out.println(vn.isNumber("1234f"));
    }

    public boolean isNumber(String s) {
        s = s.trim();

        boolean seenPoint = false;
        boolean seenE = false;
        boolean seenNumber = false;
        boolean seenNumberAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar >= '0' && currChar <= '9') {
                seenNumber = true;
                seenNumberAfterE = true;
            } else if (currChar == 'e') {
                if (!seenNumber || seenE) {
                    return false;
                }
                seenNumberAfterE = false;
                seenE = true;
            } else if (currChar == '.') {
                if (seenE || seenPoint) {
                    return false;
                }
                seenPoint = true;
            } else if (currChar == '+' || currChar == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return seenNumber && seenNumberAfterE;
    }
}
