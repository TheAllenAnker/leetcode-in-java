package com.delicate.leetcode.foroffers.bytedance;

public class GetKthPermutation {
    public static void main(String[] args) {
        System.out.println(getKthPermutation(3, 3));
        System.out.println(getKthPermutation(4, 9));
    }

    public static String getKthPermutation(int n, int k) {
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        StringBuilder res = new StringBuilder();
        StringBuilder numbers = new StringBuilder("123456789");
        k--;
        for (int i = n; i >= 1; i--) {
            int j = k / factorials[i - 1];
            k %= factorials[i - 1];
            res.append(numbers.charAt(j));
            numbers.deleteCharAt(j);
        }
        return res.toString();
    }
}
