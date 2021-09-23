package com.practice.problems.easy;

import java.util.LinkedList;

public class ImplementStackUsingQueues {

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        LinkedList<Integer> temp = queue1;
        queue2 = queue1;
        queue1 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
