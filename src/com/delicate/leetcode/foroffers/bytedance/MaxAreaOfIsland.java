package com.delicate.leetcode.foroffers.bytedance;

public class MaxAreaOfIsland {
    private int area;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int maxArea = area;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                area = 0;
                if (!seen[i][j]) {
                    check(seen, grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private void check(boolean[][] seen, int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (seen[i][j]) {
            return;
        }
        seen[i][j] = true;
        if (grid[i][j] == 1) {
            area++;
            check(seen, grid, i - 1, j);
            check(seen, grid, i, j + 1);
            check(seen, grid, i + 1, j);
            check(seen, grid, i, j - 1);
        }
    }
}
