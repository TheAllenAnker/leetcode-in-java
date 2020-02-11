package com.delicate.leetcode.easy;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(43261596));
        System.out.println(Integer.toBinaryString(reverseBits(43261596)));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}
