package com.delicate.leetcode.foroffers.easy;

public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix, 20));
        System.out.println(findNumberIn2DArray(matrix, 5));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int currVal = matrix[row][col];
            if (currVal == target) {
                return true;
            } else if (currVal > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
