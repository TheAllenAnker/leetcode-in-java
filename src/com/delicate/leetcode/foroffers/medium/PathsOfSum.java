package com.delicate.leetcode.foroffers.medium;

import com.delicate.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathsOfSum {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
        List<List<Integer>> paths = new PathsOfSum().pathsOfSum(root, 22);
        System.out.println(paths);
    }

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> currPath = new ArrayList<>();

    public List<List<Integer>> pathsOfSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }

        sum -= root.val;
        currPath.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(currPath));
        }

        if (root.left != null) {
            pathsOfSum(root.left, sum);
        }
        if (root.right != null) {
            pathsOfSum(root.right, sum);
        }
        currPath.remove(currPath.size() - 1);
        return result;
    }
}
