package jiabin.leetcode.搜索;

import common.TreeNode;

public class 验证二叉树搜索 {

    public static void main(String[] args) {

    }

    /**
     * 这么实现是有问题的，只考虑了当前节点
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (!isValueOk(root)) {
            return false;
        }

        //验证左子树
        boolean left = isValidBST(root.left);
        //验证右子树
        boolean right = isValidBST(root.right);
        //左子树和右子树都是BST返回true
        return left && right;
    }

    private boolean isValueOk(TreeNode root) {
        if (root.left != null && root.right != null) {
            return root.left.val < root.val && root.right.val > root.val;
        } else if (root.left != null && root.right == null) {
            return root.left.val < root.val;
        } else if (root.right != null && root.left == null) {
            return root.right.val > root.val;
        } else {
            return true;
        }
    }

    /**
     * 修正方法1的bug，左节点不应该只和父节点比较，而是应该小于本路径的最小值
     * 右节点也不应只大于父节点就够了，还应该大于路径上最大的点
     * 右节点必须
     *
     * @param treeNode
     */
    public boolean isValidBST2(TreeNode treeNode) {
        return fixIsValidBST2(treeNode, null, null);
    }

    private boolean fixIsValidBST2(TreeNode root, Integer lowest, Integer highest) {
        if (root == null) {
            return true;
        }

        if (lowest != null && root.val >= lowest) {
            return false;
        }

        if (highest != null && root.val <= highest) {
            return false;
        }

        //关键点在于如何记录 本路径的最小值和最大值
        return fixIsValidBST2(root.left, root.val, highest) && fixIsValidBST2(root.right, lowest, root.val);


    }
}
