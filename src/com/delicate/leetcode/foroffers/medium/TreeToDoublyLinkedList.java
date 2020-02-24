package com.delicate.leetcode.foroffers.medium;

import com.delicate.leetcode.bean.TreeNode;

public class TreeToDoublyLinkedList {
    public static void main(String[] args) {

    }

    private TreeNode head = null, prev = null, tail = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        inOrderTraversalAndLink(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void inOrderTraversalAndLink(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversalAndLink(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        tail = root;
        inOrderTraversalAndLink(root.right);
    }
}
