package com.delicate.leetcode.easy;

import com.delicate.leetcode.bean.ListNode;

public class MergeSortedLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode tmp1 = l1, tmp2 = l2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val > tmp2.val) {
                curr.next = tmp2;
                tmp2 = tmp2.next;
            } else {
                curr.next = tmp1;
                tmp1 = tmp1.next;
            }
            curr = curr.next;
        }
        if (tmp1 == null) {
            curr.next = tmp2;
        } else {
            curr.next = tmp1;
        }

        return head.next;
    }
}
