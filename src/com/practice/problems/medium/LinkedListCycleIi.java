package com.practice.problems.medium;

import java.util.HashSet;

public class LinkedListCycleIi {

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            var set = new HashSet<ListNode>();
            while(head != null) {
                if (set.contains(head)) {
                    return head;
                }
                set.add(head);
                head = head.next;
            }
            return null;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
