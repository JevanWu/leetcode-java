package com.practice.problems.easy;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] count = new int[n + 1];
        if (n < 2) return n;
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            count[i] = count[i - 1] + count[i - 2];
        }
        return count[n];
    }
}
