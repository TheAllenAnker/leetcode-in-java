package com.delicate.leetcode.foroffers.medium;

import java.util.ArrayList;
import java.util.List;

public class MinNumber {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
        System.out.println(minNumber(new int[]{3,30,34,5,9}));
    }

    public static String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }
}
