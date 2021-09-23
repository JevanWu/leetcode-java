package com.practice.problems.easy;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    PriorityQueue<Integer> queue;
    Integer k;

    public KthLargestElementInAStream(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        this.k = k;
        for (Integer i:nums) {
            queue.add(i);
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
