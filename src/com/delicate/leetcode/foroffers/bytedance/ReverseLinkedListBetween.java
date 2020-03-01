package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.ListNode;

public class ReverseLinkedListBetween {
    public static void main(String[] args) {
        ReverseLinkedListBetween rllb = new ReverseLinkedListBetween();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.print();
        head = rllb.reverseBetween(head, 2, 4);
        head.print();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head, leftPartEnd = null;
        for (int i = 1; i < m; i++) {
            leftPartEnd = start;
            start = start.next;
        }
        ListNode end = start;
        for (int i = m; i < n; i++) {
            end = end.next;
        }

        ListNode rightPartStart = end.next;
        end.next = null;
        reverseLinkedList(start);
        if (leftPartEnd != null) {
            leftPartEnd.next = end;
        }
        start.next = rightPartStart;

        return leftPartEnd == null ? end : head;
    }

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
