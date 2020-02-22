package com.delicate.leetcode.foroffers.easy;

import com.delicate.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthLargest(root, 1));
    }

    public static int kthLargest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            throw new IllegalArgumentException();
        }

        List<Integer> nodeValues = new ArrayList<>();
        postTraversal(root, nodeValues);
        return nodeValues.get(nodeValues.size() - k);
    }

    private static void postTraversal(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        postTraversal(root.left, values);
        values.add(root.val);
        postTraversal(root.right, values);
    }
}
