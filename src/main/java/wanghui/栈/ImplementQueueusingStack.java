package wanghui.栈;

import java.util.Stack;

public class ImplementQueueusingStack {
    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;
    /** Initialize your data structure here. */
    public ImplementQueueusingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        dao();
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        dao();
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     倒数原则：1、只有当stack2为空时才可以倒
     2、要倒就一次倒完
     **/
    public void dao() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

    }
}
