package wanghui.栈;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) {
            return ans;
        }

        postorderTraversal(root.left);

        postorderTraversal(root.right);

        ans.add(root.val);

        return ans;
    }

    /**
     * 两个栈
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        if(root==null) {
            return ans;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if(root.left!=null) {
                stack1.push(root.left);
            }
            if(root.right!=null) {
                stack1.push(root.right);
            }
        }
        while(!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        return ans;
    }

}
