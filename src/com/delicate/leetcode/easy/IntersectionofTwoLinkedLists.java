package com.delicate.leetcode.easy;

import com.delicate.leetcode.bean.ListNode;

public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0, lenB = 0;
        ListNode currNode = headA;
        while (currNode != null) {
            lenA++;
            currNode = currNode.next;
        }
        currNode = headB;
        while (currNode != null) {
            lenB++;
            currNode = currNode.next;
        }
        ListNode curr1 = headA, curr2 = headB;
        int step = lenB - lenA;
        while (step > 0) {
            curr2 = curr2.next;
            step--;
        }
        while (step < 0) {
            curr1 = curr1.next;
            step++;
        }
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null;
    }
}
