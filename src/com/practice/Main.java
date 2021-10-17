package com.practice;

import com.practice.problems.hard.SlidingWindowMaximum;

public class Main {

    public static void main(String[] args) {
        // write your code here
        var sliding = new SlidingWindowMaximum();
        var nums = new int[]{ 1,3,-1,-3,5,3,6,7 };
        sliding.maxSlidingWindow(nums, 3);
    }
}
