package com.delicate.leetcode.bean;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTree(List<Integer> vals) {
        if (vals == null || vals.size() == 0) {
            return null;
        }

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        currLevel.offer(root);
        TreeNode left, right = null;
        for (int i = 1; i < vals.size(); i++) {
            TreeNode currNode = currLevel.remove();
            if (currNode == null) {
                continue;
            }
            left = vals.get(i) == null ? null : new TreeNode(vals.get(i));
            i++;
            if (i < vals.size()) {
                right = vals.get(i) == null ? null : new TreeNode(vals.get(i));
            }
            nextLevel.offer(left);
            nextLevel.offer(right);
            currNode.left = left;
            currNode.right = right;
            if (currLevel.isEmpty()) {
                currLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
        return root;
    }
}
