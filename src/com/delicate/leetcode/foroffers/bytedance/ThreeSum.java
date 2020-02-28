package com.delicate.leetcode.foroffers.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        List<Integer> currList;
        int i = 0;
        while (i < len) {
            if (nums[i] > 0) break;
            int target = -nums[i];
            if (i > 0 && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            int start = i + 1, end = len - 1;
            while (start < end) {
                int startNum = nums[start], endNum = nums[end];
                if (startNum + endNum == target) {
                    currList = new ArrayList<>(Arrays.asList(startNum, endNum, nums[i]));
                    result.add(currList);
                    while (start < end && nums[start + 1] == nums[start]) start++;
                    while (start < end && nums[end - 1] == nums[end]) end--;
                    start++;
                    end--;
                } else if (startNum + endNum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            i++;
        }
        return result;
    }
}
