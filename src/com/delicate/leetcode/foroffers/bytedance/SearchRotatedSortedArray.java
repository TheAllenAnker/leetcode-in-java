package com.delicate.leetcode.foroffers.bytedance;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
        System.out.println(search(new int[]{0, 1, 2, 4, 5, 6, 7}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int left = 0, right = len - 1;
        // if the array is not actually rotated
        if (nums[left] < nums[right]) {
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                int currNum = nums[mid];
                if (currNum == target) {
                    return mid;
                } else if (currNum > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } else {
            if (target > nums[right]) {
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    int currNum = nums[mid];
                    if (currNum < nums[len - 1]) {
                        right = mid - 1;
                        continue;
                    }
                    if (currNum == target) {
                        return mid;
                    } else if (currNum > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    int currNum = nums[mid];
                    if (currNum > nums[len - 1]) {
                        left = mid + 1;
                        continue;
                    }
                    if (currNum == target) {
                        return mid;
                    } else if (currNum > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
