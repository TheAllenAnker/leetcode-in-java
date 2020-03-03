package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.ListNode;

public class MergeKLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;
        while (len > 1) {
            int k = len % 2 == 0 ? len / 2 : (len / 2) + 1;
            for (int i = 0; i < len; i++) {
                lists[i] = mergeTwoLinkedList(lists[i], lists[k + i]);
            }
            len = k;
        }

        return lists[0];
    }

    private ListNode mergeTwoLinkedList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode curr1 = l1, curr2 = l2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        if (curr1 != null) {
            curr.next = curr1;
        }
        if (curr2 != null) {
            curr.next = curr2;
        }
        return head.next;
    }
}
