package com.delicate.leetcode.foroffers.bytedance;

import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

    public static String simplifyPath(String path) {
        LinkedList<String> nameList = new LinkedList<>();
        int i = 0, len = path.length();
        while (i < len) {
            // skip extra '/'
            if (path.charAt(i) == '/') {
                while (i + 1 < len && path.charAt(i + 1) == '/') {
                    i++;
                }
            }
            i++;
            // next two chars are '..'
            if (i < len) {
                if (path.charAt(i) == '.') {
                    if (i + 1 < len && path.charAt(i + 1) == '.') {
                        if (!nameList.isEmpty()) {
                            nameList.removeLast();
                        }
                        i += 2;
                    } else {
                        i++;
                    }
                } else {
                    int j = i;
                    while (j < len && path.charAt(j) != '/') {
                        j++;
                    }
                    nameList.addLast(path.substring(i, j));
                    i = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('/');
        while (!nameList.isEmpty()) {
            sb.append(nameList.removeFirst());
            if (!nameList.isEmpty()) {
                sb.append('/');
            }
        }
        return sb.toString();
    }
}
