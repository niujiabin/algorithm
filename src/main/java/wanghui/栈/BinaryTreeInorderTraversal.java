package wanghui.栈;

import common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    /**
     * 递归版本
     */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) {
            return ans;
        }
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }

    /**
     * 非递归版本
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if(root==null) {
            return ans;
        }
        /**
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left!=null) {
                stack.push(node);
                stack.push(node.left);
                if(node.right!=null) {
                    stack.push(node.right);
                }
            }else {
                ans.add(node.val);
                if(node.right!=null) {
                    stack.push(node.right);
                }
            }
        }
         **/
        return ans;
    }

}
