package com.delicate.leetcode.foroffers.medium;

import com.delicate.leetcode.bean.TreeNode;

public class IsSubtree {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return dfs(A, B) || isSubtree(A.left, B) || isSubtree(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
