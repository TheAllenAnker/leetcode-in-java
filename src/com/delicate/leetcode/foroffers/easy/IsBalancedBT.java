package com.delicate.leetcode.foroffers.easy;

import com.delicate.leetcode.bean.TreeNode;

import java.util.Arrays;

public class IsBalancedBT {
    public static void main(String[] args) {
        System.out.println(isBalanced(TreeNode.buildTree(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4))));
        System.out.println(isBalanced(TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7))));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
