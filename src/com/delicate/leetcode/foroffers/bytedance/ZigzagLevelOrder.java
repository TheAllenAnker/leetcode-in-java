package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayDeque<TreeNode> nodeDeque = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextDeque = new ArrayDeque<>();
        nodeDeque.addLast(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        TreeNode currNode;
        boolean fromLeft = true;
        while (!nodeDeque.isEmpty()) {
            currNode = fromLeft ? nodeDeque.removeFirst() : nodeDeque.removeLast();
            if (fromLeft) {
                if (currNode.left != null) {
                    nextDeque.addLast(currNode.left);
                }
                if (currNode.right != null) {
                    nextDeque.addLast(currNode.right);
                }
            } else {
                if (currNode.right != null) {
                    nextDeque.addLast(currNode.right);
                }
                if (currNode.left != null) {
                    nextDeque.addLast(currNode.left);
                }
            }
            currList.add(currNode.val);
            if (nodeDeque.isEmpty()) {
                nodeDeque = nextDeque;
                nextDeque = new ArrayDeque<>();
                result.add(currList);
                currList = new ArrayList<>();
                fromLeft = !fromLeft;
            }
        }

        return result;
    }
}