package com.delicate.leetcode.foroffers.bytedance;

public class TrapRainwater {
    public static void main(String[] args) {
        System.out.println(trapRainwater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapRainwater(new int[]{1}));
    }

    public static int trapRainwater(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int len = height.length;
        int[] fromLeft = new int[len];
        int[] fromRight = new int[len];
        int preMax = height[0];
        fromLeft[0] = height[0];
        fromRight[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            if (height[i] > preMax) {
                fromLeft[i] = height[i];
                preMax = height[i];
                continue;
            }
            fromLeft[i] = preMax;
        }
        preMax = height[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (height[i] > preMax) {
                fromRight[i] = height[i];
                preMax = height[i];
                continue;
            }
            fromRight[i] = preMax;
        }

        for (int i = 0; i < len; i++) {
            result += Math.min(fromLeft[i], fromRight[i]);
            result -= height[i];
        }
        return result;
    }
}
