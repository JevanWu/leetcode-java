package com.practice.problems.medium;

// 200. 岛屿数量
public class NumberOfIslands {

    private static class UnionFind {
        int[] parent;
        int rootCount = 0;

        UnionFind(char[][] grid) {
            var m = grid.length;
            var n = grid[0].length;
            parent = new int[m * n];
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    if (grid[j][i] == '1') {
                        parent[j * n + i] = j * n + i;
                        rootCount++;
                    }
                }
            }
        }

        public int findParent(int i) {
            if (parent[i] != i) parent[i] = findParent(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootY = findParent(y);
            int rootX = findParent(x);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            rootCount--;
        }

        public int getRootCount() {
            return rootCount;
        }
    }

    // 1. 并查集解法
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        var unionFind = new UnionFind(grid);
        var m = grid.length;
        var n = grid[0].length;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i > 0 && (grid[j][i - 1] == '1') && (grid[j][i] == '1')) {
                    unionFind.union(j * n + i, j * n + i - 1);
                }
                if (j > 0 && (grid[j - 1][i] == '1') && (grid[j][i] == '1')) {
                    unionFind.union(j * n + i, (j - 1) * n + i);
                }
            }
        }
        return unionFind.getRootCount();
    }

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '1', '1', '0'};
        grid[1] = new char[]{'1', '1', '0', '1', '0'};
        grid[2] = new char[]{'1', '1', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '0', '0'};
        int number = islands.numIslands1(grid);
        System.out.println(number);
    }
}
