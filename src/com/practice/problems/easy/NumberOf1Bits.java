package com.practice.problems.easy;

/**
 * 位1的个数
 * 又称汉明重量 hamming weight
 */
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count += 1;
            }
        }
        return count;
    }
}
