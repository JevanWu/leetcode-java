package com.practice.problems.medium;

public class PowxN {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;

        double half = n > 0 ? myPow(x, n/ 2) : myPow(x,  -(n / 2));
        double result;
        if (n % 2 != 0) {
            result = half * half * x;
        } else {
            result = half * half;
        }
        return n > 0 ? result : 1/result;
    }
}
