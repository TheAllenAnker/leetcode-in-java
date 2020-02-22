package com.delicate.leetcode.foroffers.easy;

import com.delicate.leetcode.bean.TreeNode;

public class MaxDepthOfBT {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
