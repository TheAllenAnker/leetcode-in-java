package com.delicate.leetcode.foroffers.medium;

import java.util.ArrayDeque;

public class ValidateStackSequences {
    public static void main(String[] args) {
        ValidateStackSequences vss = new ValidateStackSequences();
        System.out.println(vss.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(vss.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0, j = 0;
        while (j < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[j]) {
                if (i == pushed.length) {
                    return false;
                }
                stack.push(pushed[i++]);
            } else {
                stack.pop();
                j++;
            }
        }
        return true;
    }
}
