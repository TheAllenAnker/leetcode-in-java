package com.delicate.leetcode.foroffers;

import com.delicate.leetcode.bean.TreeNode;

public class LowestCommonAncestorOfBST {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        int pVal = p.val, qVal = q.val;
        int parentVal = root.val;
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
