package com.delicate.leetcode.foroffers.bytedance;

import com.delicate.leetcode.bean.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) {
            return l2;
        }
        if (l2 == null || l2.val == 0) {
            return l1;
        }

        ListNode curr1 = l1, curr2 = l2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int sum, carry = 0;
        while (curr1 != null && curr2 != null) {
            sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            sum %= 10;
            curr.next = new ListNode(sum);
            curr1 = curr1.next;
            curr2 = curr2.next;
            curr = curr.next;
        }
        ListNode longerCurr = curr1 == null ? curr2 : curr1;
        while (longerCurr != null) {
            sum = longerCurr.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            longerCurr = longerCurr.next;
            curr = curr.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}
