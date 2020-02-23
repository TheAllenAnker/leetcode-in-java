package com.delicate.leetcode.foroffers.medium;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "SEE"));
        System.out.println(ws.exist(board, "ABCB"));
    }

    private char[][] board;
    private boolean[][] visited;
    private String word;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        int row = board.length, col = board[0].length;
        this.board = board;
        this.word = word;
        this.visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (helper(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(int i, int j, int currIndex) {
        int row = board.length, col = board[0].length;
        if (currIndex == word.length()) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j]) {
            return false;
        }
        if (currIndex == word.length() - 1) {
            return word.charAt(currIndex) == board[i][j];
        }
        if (board[i][j] == word.charAt(currIndex) && !visited[i][j]) {
            visited[i][j] = true;
            if (helper(i - 1, j, currIndex + 1)
                    || helper(i, j + 1, currIndex + 1)
                    || helper(i + 1, j, currIndex + 1)
                    || helper(i, j - 1, currIndex + 1)) {
                return true;
            }
            visited[i][j] = false;
        }

        return false;
    }
}
