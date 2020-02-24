package com.delicate.leetcode.foroffers.medium;

public class VerifyBSTPostOrder {
    public static void main(String[] args) {

    }

    public boolean verifyPostOrder(int[] postOrder) {
        if (postOrder == null || postOrder.length == 0) {
            return false;
        }

        return verify(postOrder, 0, postOrder.length - 1);
    }

    private boolean verify(int[] postOrder, int start, int end) {
        if (end - start <= 1) {
            return true;
        }

        int border = start - 1;
        int rootVal = postOrder[end];
        while (border + 1 <= end && postOrder[border + 1] < rootVal) {
            border++;
        }
        for (int i = border + 1; i < end; i++) {
            if (postOrder[i] < rootVal) {
                return false;
            }
        }
        return verify(postOrder, start, border) && verify(postOrder, border + 1, end - 1);
    }
}
