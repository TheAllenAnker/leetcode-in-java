package com.delicate.leetcode.foroffers;

import java.util.Arrays;

public class SpiralPrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(spiralPrint(matrix)));
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(Arrays.toString(spiralPrint(matrix1)));
        int[][] matrix2 = {
                {1},
                {5}
        };
        System.out.println(Arrays.toString(spiralPrint(matrix2)));
    }

    public static int[] spiralPrint(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        int rowLen = matrix.length, colLen = matrix[0].length;
        int[] result = new int[rowLen * colLen];
        int currIndex = 0;
        int r1 = 0, r2 = rowLen - 1;
        int c1 = 0, c2 = colLen - 1;
        while (c1 <= c2 && r1 <= r2) {
            for (int c = c1; c <= c2; c++) {
                result[currIndex++] = matrix[r1][c];
            }
            for (int r = r1 + 1; r <= r2; r++) {
                result[currIndex++] = matrix[r][c2];
            }
            if (currIndex < result.length) {
                for (int c = c2 - 1; c > c1; c--) {
                    result[currIndex++] = matrix[r2][c];
                }
                for (int r = r2; r > r1; r--) {
                    result[currIndex++] = matrix[r][c1];
                }
            }
            c1++;
            r1++;
            c2--;
            r2--;
        }
        return result;
    }
}
