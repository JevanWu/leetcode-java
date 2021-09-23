package com.practice.problems.easy;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private final Stack<Integer> inputStack = new Stack<Integer>();
    private final Stack<Integer> outputStack = new Stack<Integer>();

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        flush();
        return outputStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        flush();
        return outputStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        flush();
        return outputStack.empty();
    }

    private void flush() {
        while (!inputStack.empty()) {
            var item = inputStack.pop();
            outputStack.push(item);
        }
    }

}
