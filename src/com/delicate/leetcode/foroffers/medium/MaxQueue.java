package com.delicate.leetcode.foroffers.medium;

import java.util.ArrayDeque;

public class MaxQueue {
    private ArrayDeque<Integer> dataQueue;
    private ArrayDeque<Integer> maxQueue;

    public MaxQueue() {
        dataQueue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (dataQueue.isEmpty()) {
            return -1;
        }

        return maxQueue.getFirst();
    }

    public void push_back(int value) {
        dataQueue.addLast(value);
        while (!maxQueue.isEmpty() && maxQueue.getLast() < value) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (dataQueue.isEmpty()) {
            return -1;
        }

        int val = dataQueue.removeFirst();
        if (val == maxQueue.getFirst()) {
            maxQueue.removeFirst();
        }
        return val;
    }
}
