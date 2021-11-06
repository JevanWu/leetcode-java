package com.practice.problems.medium;

import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] sums = new int[triangle.size()][triangle.size()];
        int minSum = Integer.MAX_VALUE;
        sums[0][0] = triangle.get(0).get(0);
        if (triangle.size() == 1) return sums[0][0];
        for (int y = 1; y < triangle.size(); y++) {
            List<Integer> row = triangle.get(y);
            for (int x = 0; x < row.size(); x++) {
                int diff = 0;
                if (x == 0) {
                    diff = sums[y - 1][x];
                } else if (x == row.size() - 1) {
                    diff = sums[y - 1][x - 1];
                } else {
                    diff = Math.min(sums[y - 1][x], sums[y - 1][x - 1]);
                }
                sums[y][x] = triangle.get(y).get(x) + diff;
                if (y == triangle.size() - 1) {
                    minSum = sums[y][x] < minSum ? sums[y][x] : minSum;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        var t = new Triangle();
        var min = t.minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)));
        System.out.println(min);
    }
}
