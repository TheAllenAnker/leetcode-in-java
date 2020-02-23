package com.delicate.leetcode.foroffers.medium;

import com.delicate.leetcode.bean.TreeNode;

import java.util.*;

public class TreeZigZagLevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> currLevelNodes = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevelNodes = new ArrayDeque<>();
        currLevelNodes.add(root);
        List<Integer> currLevelValuesList = new ArrayList<>();
        boolean reverse = false;
        TreeNode currNode;
        while (!currLevelNodes.isEmpty()) {
            currNode = currLevelNodes.removeLast();
            currLevelValuesList.add(currNode.val);
            if (!reverse) {
                if (currNode.left != null) {
                    nextLevelNodes.add(currNode.left);
                }
                if (currNode.right != null) {
                    nextLevelNodes.add(currNode.right);
                }
            } else {
                if (currNode.right != null) {
                    nextLevelNodes.add(currNode.right);
                }
                if (currNode.left != null) {
                    nextLevelNodes.add(currNode.left);
                }
            }
            if (currLevelNodes.isEmpty()) {
                currLevelNodes = nextLevelNodes;
                nextLevelNodes = new ArrayDeque<>();
                result.add(currLevelValuesList);
                currLevelValuesList = new ArrayList<>();
                reverse = !reverse;
            }
        }
        return result;
    }
}
