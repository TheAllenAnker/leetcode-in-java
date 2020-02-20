package com.delicate.leetcode.foroffers;

import com.delicate.leetcode.bean.TreeNode;

public class MirrorTree {
    public static void main(String[] args) {

    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = mirrorTree(root.right);
        newRoot.right = mirrorTree(root.left);
        return newRoot;
    }
}
