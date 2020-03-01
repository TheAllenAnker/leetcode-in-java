package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.ListNode;

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
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
