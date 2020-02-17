package com.delicate.leetcode.easy;

import java.util.ArrayDeque;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private ArrayDeque<Integer> dataStack;
    private ArrayDeque<Integer> minStack;

    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.addLast(x);
        if (minStack.isEmpty() || x < minStack.getLast()) {
            minStack.addLast(x);
        } else {
            minStack.addLast(minStack.getLast());
        }
    }

    public void pop() {
        dataStack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return dataStack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}
