package com.practice.problems.easy;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        var first = head;
        if (first == null || first.next == null) {
            return first;
        }
        var second = head.next;
        var newHead = swapPairs(second.next);
        second.next = first;
        first.next = newHead;
        return second;
    }


    /*
     * Definition for singly-linked list
     */
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
}


