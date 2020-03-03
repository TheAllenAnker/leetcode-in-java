package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.TreeNode;

import java.util.Stack;

public class IsValidBST {
    public boolean isValidBSTByRecursion(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer smaller, Integer bigger) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (smaller != null && val <= smaller) {
            return false;
        }
        if (bigger != null && val >= bigger) {
            return false;
        }

        return helper(root.left, smaller, val) && helper(root.right, val, bigger);
    }

    public boolean isValidBSTByTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, pre = null;
        while (!stack.isEmpty() || curr != null) {
            if (curr.left != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (pre != null && curr.val <= pre.val) {
                    return false;
                }
                pre = curr;
                curr = curr.right;
            }
        }

        return true;
    }
}