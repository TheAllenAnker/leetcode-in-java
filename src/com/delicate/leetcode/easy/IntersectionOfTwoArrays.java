package com.delicate.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int i1 = 0, i2 = 0;
        ArrayList<Integer> resultList = new ArrayList<>();
        while (i1 < len1 && i2 < len2) {
            if (nums1[i1] == nums2[i2]) {
                resultList.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
