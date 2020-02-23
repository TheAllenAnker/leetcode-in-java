package com.delicate.leetcode.foroffers.medium;

public class MovingCount {
    public static void main(String[] args) {

    }

    private int count;
    private boolean[][] checked;

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }

        checked = new boolean[m][n];
        check(0, 0, k);
        return count;
    }

    private void check(int i, int j, int k) {
        if (i < 0 || i >= checked.length || j < 0 || j >= checked[0].length || checked[i][j]) {
            return;
        }
        int sum = digitsSum(i) + digitsSum(j);
        if (sum <= k) {
            count++;
            checked[i][j] = true;
            check(i - 1, j, k);
            check(i, j + 1, k);
            check(i + 1, j, k);
            check(i, j - 1, k);
        }
    }

    private int digitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
