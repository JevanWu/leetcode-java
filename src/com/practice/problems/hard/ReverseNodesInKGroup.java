package com.practice.problems.hard;

import java.util.List;
import java.util.Stack;

public class ReverseNodesInKGroup {

    /**
     * Definition for singly-linked list.
     * /
     * /
     **/
    public class ListNode {
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


    public ListNode reverseKGroup(ListNode head, int k) {
        var originalHead = head;
        var stack = new Stack<ListNode>();
        for(int index = 0; index < k; index++) {
            if (head == null) {
                return originalHead;
            }
            stack.push(head);
            head = head.next;
        }

        // 反转
        ListNode firstNode = stack.pop();
        var consequence = firstNode.next;
        ListNode lastNode = firstNode;
        ListNode prev = firstNode;
        while(!stack.isEmpty()) {
            var node = stack.pop();
            prev.next = node;
            prev = node;
            lastNode = node;
        }
        lastNode.next = reverseKGroup(consequence, k);
        return firstNode;
    }
}
