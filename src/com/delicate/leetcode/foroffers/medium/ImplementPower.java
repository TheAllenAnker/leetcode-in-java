package com.delicate.leetcode.foroffers.medium;

public class ImplementPower {
    public static void main(String[] args) {
        System.out.println(new ImplementPower().myPow(2.0, 10));
        System.out.println(new ImplementPower().myPow(2.10, 3));
        System.out.println(new ImplementPower().myPow(2.0, -2));
    }

    public double myPow(double x, int n) {
        double result = absMyPow(x, Math.abs(n));
        return n < 0 ? 1 / result : result;
    }

    private double absMyPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        // if n is odd
        if ((n & 1) == 0) {
            double result = absMyPow(x, n >>> 1);
            return result * result;
        } else {
            double result = myPow(x, (n - 1) >>> 1);
            return result * result * x;
        }
    }
}
