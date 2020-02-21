package com.delicate.leetcode.foroffers;

import com.delicate.leetcode.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelPrintBT {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelPrintBT(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayDeque<TreeNode> currLevelQueue = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevelQueue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currLevelList = new ArrayList<>();
        currLevelQueue.addLast(root);
        while (!currLevelQueue.isEmpty()) {
            while (!currLevelQueue.isEmpty()) {
                TreeNode currNode = currLevelQueue.removeFirst();
                currLevelList.add(currNode.val);
                if (currNode.left != null) {
                    nextLevelQueue.addLast(currNode.left);
                }
                if (currNode.right != null) {
                    nextLevelQueue.addLast(currNode.right);
                }
            }
            result.add(currLevelList);
            currLevelList = new ArrayList<>();
            currLevelQueue = nextLevelQueue;
            nextLevelQueue = new ArrayDeque<>();
        }
        return result;
    }
}
