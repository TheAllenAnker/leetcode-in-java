package com.delicate.leetcode.foroffers.bytedance;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return maxSum(nums, 0, nums.length - 1);
    }

    private int maxSum(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        int res;
        int mid = (i + j) / 2;
        res = Math.max(maxSum(nums, i, mid), maxSum(nums, mid + 1, j));
        // 计算左部分最大连续序列和
        int tmpl = nums[mid], t = 0;
        for (int k = mid; k >= i; k--) {
            tmpl = Math.max(tmpl, t += nums[k]);
        }
        t = 0;
        // 计算右部分最大连续序列和
        int tmpr = nums[mid + 1];
        for (int k = mid + 1; k <= j; k++) {
            tmpr = Math.max(tmpr, t += nums[k]);
        }
        // 单独左/右部分 或者 左右部分和中间合在一起，判断哪部分大返回哪个结果
        return Math.max(res, tmpl + tmpr);
    }
}
