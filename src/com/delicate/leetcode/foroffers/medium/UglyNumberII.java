package com.delicate.leetcode.foroffers.medium;

public class UglyNumberII {
    public static Ugly ugly = new Ugly();

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        return ugly.nums[n - 1];
    }
}

class Ugly {
    public int[] nums = new int[1690];

    Ugly() {
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;
        int num2, num3, num5;
        for (int i = 1; i < 1690; i++) {
            num2 = 2 * nums[i2];
            num3 = 3 * nums[i3];
            num5 = 5 * nums[i5];
            ugly = Math.min(Math.min(num2, num3), num5);
            if (ugly == num2) {
                i2++;
            }
            if (ugly == num3) {
                i3++;
            }
            if (ugly == num5) {
                i5++;
            }
            nums[i] = ugly;
        }
    }
}
