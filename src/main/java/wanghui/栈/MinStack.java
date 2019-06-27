package wanghui.栈;

import java.util.Stack;

public class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if(!minStack.isEmpty()) {
            minStack.push(x<minStack.peek()?x:minStack.peek());
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        if(!dataStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        minStack.peek();
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
