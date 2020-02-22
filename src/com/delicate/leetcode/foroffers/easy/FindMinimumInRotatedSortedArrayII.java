package com.delicate.leetcode.foroffers.easy;

public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(minInRotatedSortedArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minInRotatedSortedArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minInRotatedSortedArray(new int[]{0, 1}));
    }

    public static int minInRotatedSortedArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int len = numbers.length;
        if (numbers[len - 1] > numbers[0]) {
            return numbers[0];
        }
        int prev = numbers[0];
        for (int i = 1; i < len; i++) {
            if (numbers[i] < prev) {
                prev = numbers[i];
                break;
            }
            prev = numbers[i];
        }

        return prev;
    }
}
