package com.delicate.leetcode.foroffers.easy;

import com.delicate.leetcode.bean.ListNode;

public class GetKthNodeFromTheEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = getKthNodeFromTheEnd(head, 2);
        head.print();
    }

    public static ListNode getKthNodeFromTheEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode slow = head, fast = head;
        int i = 0;
        for (; i < k && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null && i < k) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
