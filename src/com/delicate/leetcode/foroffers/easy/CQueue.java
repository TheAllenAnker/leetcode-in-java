package com.delicate.leetcode.foroffers.easy;

import java.util.ArrayDeque;

public class CQueue {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
        obj.appendTail(4);
        System.out.println(obj.deleteHead());
    }

    private ArrayDeque<Integer> dataStack;
    private ArrayDeque<Integer> popStack;

    public CQueue() {
        dataStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        dataStack.push(value);
    }

    public int deleteHead() {
        if (!popStack.isEmpty()) {
            return popStack.pop();
        } else {
            while (!dataStack.isEmpty()) {
                popStack.push(dataStack.pop());
            }
            if (popStack.isEmpty()) {
                return -1;
            } else {
                return popStack.pop();
            }
        }
    }
}
