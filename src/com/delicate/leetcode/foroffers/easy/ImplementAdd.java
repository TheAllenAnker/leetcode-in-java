package com.delicate.leetcode.foroffers.easy;

public class ImplementAdd {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int xor = (a ^ b);
            b = (a & b) << 1;
            a = xor;
        }

        return a;
    }
}
