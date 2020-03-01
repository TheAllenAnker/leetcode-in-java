package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.ListNode;

public class SortLinkedList {
    public ListNode sortListWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left, right;

        // cut
        left = sortListWithRecursion(head);
        right = sortListWithRecursion(mid);

        //merge
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return result.next;
    }

    public ListNode sortListWithoutRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prev;
        int currMergeLen = 1;
        while (currMergeLen < length) {
            prev = res;
            curr = res.next;
            while (curr != null) {
                ListNode l1 = curr;
                int c1 = currMergeLen;
                while (c1 != 0 && curr != null) {
                    c1--;
                    curr = curr.next;
                }
                if (c1 > 0) break;
                ListNode l2 = curr;
                int c2 = currMergeLen;
                while (c2 != 0 && curr != null) {
                    c2--;
                    curr = curr.next;
                }
                c1 = currMergeLen;
                c2 = currMergeLen - c2;

                // merge
                while (c1 > 0 && c2 > 0) {
                    if (l1.val < l2.val) {
                        prev.next = l1;
                        l1 = l1.next;
                        c1--;
                    } else {
                        prev.next = l2;
                        l2 = l2.next;
                        c2--;
                    }
                    prev = prev.next;
                }
                prev.next = c1 > 0 ? l1 : l2;

                // move pointer prev to current merge list end
                while (c1 > 0 || c2 > 0) {
                    prev = prev.next;
                    c1--;
                    c2--;
                }
                prev.next = curr;
            }
            currMergeLen *= 2;
        }
        return res.next;
    }
}
