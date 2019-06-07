package wanghui.栈;

import common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

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
     * 非递归版本(我想的)
     * @param root
     * @return
     */
        public static List<Integer> inorderTraversal1(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root==null) {
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            HashSet<TreeNode> set = new HashSet<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(!set.contains(node)) {
                    if(node.right!=null) {
                        stack.push(node.right);
                    }
                    stack.push(node);
                    set.add(node);
                    if(node.left!=null) {
                        stack.push(node.left);
                    }
                }else {
                    ans.add(node.val);
                }
            }
            return ans;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        List<Integer> integers = inorderTraversal1(node);
        integers.forEach(integer -> {
            System.out.println(integer+" " );
        });
    }

}
