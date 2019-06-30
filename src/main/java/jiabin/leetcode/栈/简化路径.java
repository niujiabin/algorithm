package jiabin.leetcode.栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 简化路径 {

    public static void main(String[] args) {

    }


    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] array = path.split("/");

        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.add(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        for (String item : stack) {
            sb.append("/" + item);
        }
        return sb.toString();

    }
}
