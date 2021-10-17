package com.practice.problems.medium;



public class SwapNodesInPairs {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public SwapNodesInPairs() {
    }

    public ListNode swapPairs(ListNode head) {
        var first = head;
        ListNode newHead = first.next;
        while (first.next != null && first.next.next != null) {
            // record next
            var second = first.next;
            var nextFirst = second.next;
            // swap
            first.next = nextFirst.next;
            second.next = first;

            first = nextFirst;
        }

        return newHead;
    }


    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
           return head;
        }
        ListNode second = head.next;
        ListNode newHead = swapPairs2(second.next);
        second.next = head;
        head.next = newHead;

        return second;
    }
}
