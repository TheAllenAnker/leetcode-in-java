package com.delicate.leetcode.easy;

public class Roman_to_Integer {
    public static void main(String[] args) {
        System.out.println(Roman_to_Integer.romanToInt("IV"));
        System.out.println(Roman_to_Integer.romanToInt("VII"));
        System.out.println(Roman_to_Integer.romanToInt("VII"));
        System.out.println(Roman_to_Integer.romanToInt("CD"));
        System.out.println(Roman_to_Integer.romanToInt("XL"));
    }

    public static int romanToInt(String s) {
        int[] value_map = new int[26];
        value_map['I' - 'A'] = 1;
        value_map['V' - 'A'] = 5;
        value_map['X' - 'A'] = 10;
        value_map['L' - 'A'] = 50;
        value_map['C' - 'A'] = 100;
        value_map['D' - 'A'] = 500;
        value_map['M' - 'A'] = 1000;
        char prev_c = 'A';
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (value_map[c - 'A'] > value_map[prev_c - 'A']) {
                sum -= 2 * value_map[prev_c - 'A'];
            }
            sum += value_map[c - 'A'];
            prev_c = c;
        }

        return sum;
    }
}
