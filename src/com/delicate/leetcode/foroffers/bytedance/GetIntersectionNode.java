package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        ListNode curr = headA;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        int lenB = 0;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        int diff = lenA - lenB;
        ListNode currA = headA, currB = headB;
        while (diff != 0) {
            if (diff > 0) {
                currA = currA.next;
                diff--;
            } else {
                currB = currB.next;
                diff++;
            }
        }

        while (currA != null && currB != null && currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }
}
