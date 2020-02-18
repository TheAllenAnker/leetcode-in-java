package com.delicate.leetcode.easy;

import com.delicate.leetcode.bean.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.print();
        System.out.println(isPalindrome(head));
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.print();
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        if (head.next == null) {
            return true;
        }

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        ListNode former = head;
        curr = head;
        for (int i = 0; i != length / 2; i++) {
            curr = curr.next;
        }
        ListNode latter = length % 2 == 0 ? curr : curr.next;
        latter = reverseLinkedList(latter);
        while (former != null && latter != null) {
            if (former.val != latter.val) {
                return false;
            }
            former = former.next;
            latter = latter.next;
        }

        return true;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevNode = null, currNode = head, nextNode;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }
}
