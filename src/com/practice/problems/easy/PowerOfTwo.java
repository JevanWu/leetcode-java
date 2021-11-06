package com.practice.problems.easy;

// 衍生：用更相减损术求最大公约数

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
