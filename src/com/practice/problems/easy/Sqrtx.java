package com.practice.problems.easy;

public class Sqrtx {

    // TODO: 可以多了解下牛顿迭代解法
    public int mySqrt(int x) throws InterruptedException {
        if (x <= 1) return x;
        int start = 1;
        int end = x;
        while (true) {
            int mid = start + (end - start)/2;
            if (((long)mid * mid == x) || (((long)mid * mid < x) && ((long)(mid + 1) * (mid + 1) > x))) {
                return mid;
            }
            if ((long)mid * mid > x) {
                end = mid - 1;
            } else if ((long)mid * mid < x) {
                start = mid + 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var x = 2147395599;
        System.out.println(new Sqrtx().mySqrt(x));
    }
}

