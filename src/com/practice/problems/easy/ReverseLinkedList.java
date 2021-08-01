package com.practice.problems.easy;

import java.lang.reflect.Array;
import java.util.Objects;


public class ReverseLinkedList {

    // pre-defined
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

/* 迭代版本
    public ListNode reverseList(ListNode head) {
        var current = head;
        ListNode prev = null;
        while (!Objects.isNull(current)) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
*/

/*
    TODO: 需复习
*/
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
