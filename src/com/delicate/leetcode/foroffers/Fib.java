package com.delicate.leetcode.foroffers;

public class Fib {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i));
        }
        System.out.println(fib(45));
        System.out.println(fib(48));
    }

    public static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1;
        int c = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = (a + b) % 1000000007;
        }

        return c;
    }
}
