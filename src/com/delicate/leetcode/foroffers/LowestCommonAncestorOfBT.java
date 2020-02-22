package com.delicate.leetcode.foroffers;

import com.delicate.leetcode.bean.TreeNode;

public class LowestCommonAncestorOfBT {
    private static TreeNode resultNode;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode res = new TreeNode(0);
        found(root, p.val, q.val);
        return resultNode;
    }

    private static boolean found(TreeNode root, int val1, int val2) {
        if (root == null) {
            return false;
        }

        int left = found(root.left, val1, val2) ? 1 : 0;
        int right = found(root.right, val1, val2) ? 1 : 0;
        int mid = (root.val == val1 || root.val == val2) ? 1 : 0;
        if ((left + right + mid) >= 2) {
            resultNode = root;
        }

        return (mid + left + right) > 0;
    }
}
