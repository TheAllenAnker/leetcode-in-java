package com.delicate.leetcode.easy;

import java.util.ArrayDeque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("("));
        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {
        ArrayDeque<Character> parenthesesStart = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                parenthesesStart.offer(c);
            } else {
                char start = !parenthesesStart.isEmpty() ? parenthesesStart.removeLast() : 'u';
                switch (start) {
                    case '{':
                        if (c != '}') {
                            return false;
                        }
                        break;
                    case '(':
                        if (c != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if (c != ']') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }

            }
        }

        return parenthesesStart.isEmpty();
    }
}
