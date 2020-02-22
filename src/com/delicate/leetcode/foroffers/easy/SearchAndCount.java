package com.delicate.leetcode.foroffers.easy;

public class SearchAndCount {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(search(new int[]{1}, 1));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = binarySearch(nums, target);
        if (i == -1) {
            return 0;
        }
        int start = i;
        for (int j = start; j >= 0; j--) {
            if (nums[j] == target) {
                start = j;
            } else {
                break;
            }
        }
        int end = i;
        for (int j = end; j < nums.length; j++) {
            if (nums[j] == target) {
                end = j;
            } else {
                break;
            }
        }

        return end - start + 1;
    }

    private static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int currVal = nums[mid];
            if (currVal == target) {
                return mid;
            } else if (currVal > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
