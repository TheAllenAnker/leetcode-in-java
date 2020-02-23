package com.delicate.leetcode.foroffers.medium;

import com.delicate.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderI {
    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        Queue<TreeNode> currLevelNodeQueue = new LinkedList<>();
        Queue<TreeNode> nextLevelNodeQueue = new LinkedList<>();
        ArrayList<Integer> valuesInLevelOrder = new ArrayList<>();
        currLevelNodeQueue.offer(root);
        TreeNode currNode;
        while (!currLevelNodeQueue.isEmpty()) {
            currNode = currLevelNodeQueue.remove();
            valuesInLevelOrder.add(currNode.val);
            if (currNode.left != null) {
                nextLevelNodeQueue.offer(currNode.left);
            }
            if (currNode.right != null) {
                nextLevelNodeQueue.offer(currNode.right);
            }
            if (currLevelNodeQueue.isEmpty()) {
                currLevelNodeQueue = nextLevelNodeQueue;
                nextLevelNodeQueue = new LinkedList<>();
            }
        }

        int[] result = new int[valuesInLevelOrder.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = valuesInLevelOrder.get(i);
        }
        return result;
    }
}
