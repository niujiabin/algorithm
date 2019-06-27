package jiabin.leetcode.栈;

public class 有效的括号平 {

    public static void main(String[] args) {
        有效的括号平 x = new 有效的括号平();
        x.isValid("()");
    }

    public boolean isValid(String s) {
        try {
            char[] chars = s.toCharArray();
            SimpleStack simpleStack = new SimpleStack(chars.length);
            for (int index = 0; index < chars.length; index++) {
                char current = chars[index];
                if (leftFlag(current)) {
                    simpleStack.push(current);
                } else {
                    if (!match(simpleStack.pop(), current)) {
                        return false;
                    }
                }
            }
            return simpleStack.isEmpty();
        } catch (Exception e) {
            return false;
        }

    }

    private boolean match(char pop, char current) {
        if (pop == '(' && current == ')') {
            return true;
        }
        if (pop == '[' && current == ']') {
            return true;
        }
        if (pop == '{' && current == '}') {
            return true;
        }
        return false;
    }

    private boolean leftFlag(char current) {
        return current == '(' || current == '[' || current == '{';
    }


    class SimpleStack {

        char[] arrays;
        int index = -1;
        int capacity;
        static final int DEFAULT_CAPACITY = 1 << 3;

        public SimpleStack(char[] chars) {
            arrays = chars;
        }

        public SimpleStack(int capacity) {
            this.capacity = capacity;
            arrays = new char[capacity];
        }

        public SimpleStack() {
            this(DEFAULT_CAPACITY);
        }

        public boolean push(char c) {
            if (index >= arrays.length) {
                throw new IndexOutOfBoundsException("数组访问异常");
            }
            arrays[++index] = c;
            return true;
        }

        public char pop() {
            if (index == -1) {
                throw new IndexOutOfBoundsException("数组index不能小于0");
            }
            char popElement = arrays[index];
            arrays[index--] = Character.MIN_VALUE;
            return popElement;
        }


        public boolean isEmpty() {
            return index == -1;
        }
    }
}
