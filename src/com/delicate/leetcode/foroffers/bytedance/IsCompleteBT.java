package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBT {
    public boolean isCompleteBT(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        queue.add(root);
        TreeNode curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;

            if (right != null && left == null) {
                return false;
            }
            if (leaf && left != null) {
                return false;
            }

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            } else {
                leaf = true;
            }
        }

        return true;
    }
}
