package wanghui.栈;

import common.TreeNode;

import java.util.*;

public class BinaryTreePreorderTravelsal {

    /**
     * 递归版本
     */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) {
            return ans;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }



    /**
     * 非递归（我想的）
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if(root==null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(!set.contains(node)) {
                if(node.right!=null) {
                    stack.push(node.right);
                }
                if(node.left!=null) {
                    stack.push(node.left);
                }
                set.add(node);
                stack.push(node);
            }else {
                ans.add(node.val);
            }
        }


        return ans;
    }

    /**
     * 非递归（最优）
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root==null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node.right!=null) {
                stack.push(node.right);
            }
            if(node.left!=null) {
                stack.push(node.left);
            }

            stack.push(node);

            ans.add(node.val);

        }
        return ans;
    }
}
