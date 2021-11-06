package com.practice.problems.medium;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }


        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int y = 0; y < isConnected[0].length; y ++) {
            if (isConnected[i][y] == 1 && !visited[y]) {
                visited[y] = true;
                dfs(isConnected, visited, y);
            }
        }
    }
}
