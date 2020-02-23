package com.delicate.leetcode.foroffers.medium;

public class CuttingRopeII {
    public static void main(String[] args) {
        System.out.println(new CuttingRopeII().cuttingRope(2));
        System.out.println(new CuttingRopeII().cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int mod = (int) (1e9 + 7);
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }
}
