package com.delicate.leetcode.foroffers.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.mergeIntervals(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));
    }

    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            int[] lastInterval = resultList.get(resultList.size() - 1);
            // if current interval starts before last interval ends
            if (lastInterval[1] >= currInterval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
            } else {
                resultList.add(currInterval);
            }
        }

        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
