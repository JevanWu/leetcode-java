package com.practice.problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (String[] ele:board) {
            Arrays.fill(ele, ".");
        }
        backtrace(board, n, 0);
        return ans;
    }

    private void backtrace(String [][] board, int n, int row) {
        if (row == n) {
            ans.add(convertArrayToString(board));
            return;
        }

        for (int col = 0; col < n; col ++ ) {
            if (isValid(board, n, row, col)) {
                board[row][col] = "Q";
                backtrace(board, n, row + 1);
                board[row][col] = ".";
            }
        }
    }

    private Boolean isValid(String[][] board, int n, int row, int col) {
        // 验证列
       for(int i = 0; i < row; i++)  {
           if (board[i][col] == "Q")  {
               return false;
           }
       }

       for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
           if (board[i][j] == "Q") {
               return false;
           }
       }

       for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
           if (board[i][j] == "Q") {
               return false;
           }
       }

       return  true;
    }

    private ArrayList<String> convertArrayToString(String[][] board) {
        ArrayList<String> result = new ArrayList<>();
        for (String[] item:board) {
            result.add(String.join("", item));
        }
        return result;
    }
}
