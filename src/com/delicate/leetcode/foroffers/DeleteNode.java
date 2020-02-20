package com.delicate.leetcode.foroffers;

import com.delicate.leetcode.bean.ListNode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = deleteNode(head, 3);
        head.print();
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode prev = null, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                if (prev == null) {
                    head = curr.next;
                    break;
                }
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}
