package com.delicate.leetcode.foroffers.medium;

import com.delicate.leetcode.bean.TreeNode;

import java.util.HashMap;

public class BuildTreeWithPreAndIn {
    public static void main(String[] args) {

    }

    private int[] preOrderTraversal;
    private int[] inOrderTraversal;
    private HashMap<Integer, Integer> inPosMap = new HashMap<>();
    private int currRootIndex = 0;

    public TreeNode buildTreeWithPreAndIn(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        preOrderTraversal = preorder;
        inOrderTraversal = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inPosMap.put(inorder[i], i);
        }
        return buildHelper(0, inorder.length - 1);
    }

    private TreeNode buildHelper(int in_start, int in_end) {
        if (in_start > in_end) {
            return null;
        }
        int rootVal = preOrderTraversal[currRootIndex++];
        TreeNode root = new TreeNode(rootVal);
        if (in_start < in_end) {
            int inIndex = inPosMap.get(rootVal);
            root.left = buildHelper(in_start, inIndex - 1);
            root.right = buildHelper(inIndex + 1, in_end);
        }
        return root;
    }
}
