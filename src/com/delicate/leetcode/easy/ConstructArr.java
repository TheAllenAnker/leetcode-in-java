package com.delicate.leetcode.easy;

import java.util.Arrays;

public class ConstructArr {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        int len = a.length;
        int[] result = new int[len];
        int[] fromLeft = new int[len];
        int[] fromRight = new int[len];
        int currProduct = 1;
        for (int i = 0; i < len; i++) {
            currProduct *= a[i];
            fromLeft[i] = currProduct;
        }
        currProduct = 1;
        for (int i = len - 1; i >= 0; i--) {
            currProduct *= a[i];
            fromRight[i] = currProduct;
        }
        for (int i = 0; i < len; i++) {
            result[i] = i > 0 ? fromLeft[i - 1] : 1;
            result[i] *= i < len - 1 ? fromRight[i + 1] : 1;
        }
        return result;
    }
}
