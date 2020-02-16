package com.delicate.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums3 = {2, 0};
        int[] nums4 = {1};
        merge(nums3, 1, nums4, 1);
        System.out.println(Arrays.toString(nums3));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || m < 0 || n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int i1 = m - 1, i2 = n - 1;
        int p = m + n - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[p--] = nums1[i1--];
            } else {
                nums1[p--] = nums2[i2--];
            }
        }
        while (i2 >= 0) {
            nums1[p--] = nums2[i2--];
        }
    }
}
