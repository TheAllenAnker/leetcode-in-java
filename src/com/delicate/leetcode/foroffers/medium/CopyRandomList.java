package com.delicate.leetcode.foroffers.medium;

import com.delicate.leetcode.bean.RandomListNode;

public class CopyRandomList {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        CopyRandomList crl = new CopyRandomList();
        crl.copyRandomList(head);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode curr = head, next;
        RandomListNode newNext;
        while (curr != null) {
            next = curr.next;
            newNext = new RandomListNode(curr.val);
            curr.next = newNext;
            newNext.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        RandomListNode newHead = head.next;
        curr = newHead;
        RandomListNode curr2 = head;
        while (curr != null) {
            curr2.next = curr2.next.next;
            curr2 = curr2.next;
            curr.next = curr.next == null ? null : curr.next.next;
            curr = curr.next;
        }
        return newHead;
    }
}
