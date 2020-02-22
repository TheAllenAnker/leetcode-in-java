package com.delicate.leetcode.foroffers.easy;

import com.delicate.leetcode.bean.ListNode;

import java.util.Arrays;

public class ReversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(head)));
        head.print();
    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        head = reverseLinkedList(head);
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int[] result = new int[count];
        curr = head;
        for (int i = 0; i < count; i++) {
            result[i] = curr.val;
            curr = curr.next;
        }
        head = reverseLinkedList(head);
        return result;
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
