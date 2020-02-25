package com.delicate.leetcode.foroffers.medium;

public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit fnd = new FindNthDigit();
        for (int i = 10; i < 50; i++) {
            System.out.println(fnd.findNthDigit(i));
        }
        System.out.println(fnd.findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        long digit = 2, count = 90;
        n -= 9;
        while (count * digit < n) {
            n -= count * digit;
            digit++;
            count *= 10;
        }
        int index = (int) (n / digit), mod = (int) (n % digit);
        int num = ((int) Math.pow(10, digit - 1)) - 1 + index;
        num = mod == 0 ? num : num + 1;
        String numStr = String.valueOf(num);
        int charIndex = mod == 0 ? numStr.length() - 1 : mod - 1;
        return numStr.charAt(charIndex) - '0';
    }
}
