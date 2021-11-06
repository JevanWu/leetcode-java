package com.practice.problems.medium;

/**
 * 36. 有效的数独
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] columns = new int[9][9];
        int[][] rows = new int[9][9];
        int[][][] subBox = new int[9][9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                // https://stackoverflow.com/questions/4318263/java-subtract-0-from-char-to-get-an-int-why-does-this-work
                int index = board[i][j] - '0' - 1;
                columns[j][index]++;
                rows[i][index]++;
                subBox[i/3][j/3][index]++;
                if (columns[j][index] > 1 || rows[i][index] > 1 || subBox[i/3][j/3][index] > 1)  {
                    return false;
                }
            }
        }
        return true;
    }

}
