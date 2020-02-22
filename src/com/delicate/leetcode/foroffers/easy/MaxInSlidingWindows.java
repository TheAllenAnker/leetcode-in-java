package com.delicate.leetcode.foroffers.easy;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxInSlidingWindows {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxInSlidingWindows(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxInSlidingWindows(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }

        int len = nums.length;
        int[] result = new int[len - k + 1];
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < len; i++) {
            int currNum = nums[i];
            if (i < k - 1) {
                while (!maxDeque.isEmpty() && maxDeque.getLast() < currNum) {
                    maxDeque.removeLast();
                }
                maxDeque.addLast(currNum);
            } else {
                while (!maxDeque.isEmpty() && maxDeque.getLast() < currNum) {
                    maxDeque.removeLast();
                }
                maxDeque.addLast(currNum);
                result[index++] = maxDeque.getFirst();
                if (maxDeque.getFirst() == nums[i - k + 1]) {
                    maxDeque.removeFirst();
                }
            }
        }
        return result;
    }
}
