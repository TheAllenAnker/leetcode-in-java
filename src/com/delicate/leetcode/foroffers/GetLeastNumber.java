package com.delicate.leetcode.foroffers;

import java.util.Arrays;

public class GetLeastNumber {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers(nums, 2)));
        int[] nums1 = {0, 1, 2, 1};
        System.out.println(Arrays.toString(getLeastNumbers(nums1, 1)));
        int[] nums2 = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.println(Arrays.toString(getLeastNumbers(nums2, 8)));
        int[] nums3 = {0, 1, 1, 2, 4, 4, 1, 3, 3, 2};
        System.out.println(Arrays.toString(getLeastNumbers(nums3, 6)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k < 0 || k > arr.length) {
            throw new IllegalArgumentException();
        }
        if (k == 0) {
            return new int[]{};
        }
        if (k == arr.length) {
            return arr;
        }

        int[] result = new int[k];
        buildHeap(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
            arr[0] = Integer.MAX_VALUE;
            swap(arr, 0, arr.length - 1 - i);
            heapify(arr, 0);
        }

        return result;
    }

    private static void buildHeap(int[] nums) {
        int lastIndex = nums.length - 1;
        int startIndex = (lastIndex - 1) >> 1;
        while (startIndex >= 0) {
            heapify(nums, startIndex--);
        }
    }

    private static void heapify(int[] nums, int i) {
        int len = nums.length;
        if (i >= len) {
            return;
        }

        int p1 = (i << 1) + 1, p2 = (i << 1) + 2;
        int min = i;
        if (p1 < len && nums[p1] < nums[min]) {
            min = p1;
        }
        if (p2 < len && nums[p2] < nums[min]) {
            min = p2;
        }
        if (min != i) {
            swap(nums, min, i);
            heapify(nums, min);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
