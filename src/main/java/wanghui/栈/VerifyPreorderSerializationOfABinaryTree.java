package wanghui.栈;

import java.util.Stack;
import java.util.regex.Pattern;

public class VerifyPreorderSerializationOfABinaryTree {

    /** 解法1
     * diff = outer-inner  out为子节点数量，inner为父节点数量
     * outer : 如果节点不为空，outer+2,
     * inner : 如果节点b不为空，inner+1
     * diff = outer-inner  diff如果小于0，或者最终结果不等于0，那么不是正确的序列化串
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node : nodes) {
            if(--diff<0) {return false;}
            if(!node.equals("#")) {
                diff+=2;
            }
        }
        return diff==0;
    }

    /**
     * when you iterate through the preorder traversal string, for each char:
     *
     * case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack
     *
     * case 2.1: you see a #, while top of stack is a number, you know this # is a left null child, put it there as a mark for next coming node k to know it is being the right child.
     *
     * case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child, you now cancel the sub tree (rooted as t, for example) with these two-# children. But wait, after the cancellation, you continue to check top of stack is whether # or a number:
     *
     * ---- if a number, say u, you know you just cancelled a node t which is left child of u. You need to leave a # mark to the top of stack. So that the next node know it is a right child.
     *
     * ---- if a #, you know you just cancelled a tree whose root, t, is the right child of u. So you continue to cancel sub tree of u, and the process goes on and on.
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization1(String preorder) {
        if(preorder==null || preorder.length()==0) {
            return false;
        }
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(int pos = 0; pos<strs.length; ++pos) {
            String cur = strs[pos];
            while(cur.equals("#") && !stack.isEmpty() && stack.peek().equals(cur)) {
                stack.pop();
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(cur);
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
}
