package com.practice.problems.hard;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));

    public int[] maxSlidingWindow(int[] nums, int k) {
        // initialize
        int [] result = new int[nums.length - k + 1];
        for(int index = 0; index < k; index++) {
            int[] ele = new int[]{index, nums[index]};
            priorityQueue.offer(ele);
        }

        result[0] = priorityQueue.peek()[1];

        for (int index = k; index < nums.length; index++) {
            int[] ele = priorityQueue.peek();
            int[] newEle = new int[]{index, nums[index]};
            priorityQueue.offer(newEle);
            while (ele[0] < index - k + 1) {
                priorityQueue.poll();
                ele = priorityQueue.peek();
            }
            result[index - k + 1] = ele[1];
        }
        return result;
    }
}