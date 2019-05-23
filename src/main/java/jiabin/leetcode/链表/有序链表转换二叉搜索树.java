package jiabin.leetcode.链表;

import common.ListNode;
import common.TreeNode;

/**
 * @author Administrator
 */
public class 有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        //退出条件 left == right
        if (left == right) {
            return null;
        }
        //寻找并构建中间节点
        ListNode middleNode = findMiddleNode(left, right);
        TreeNode treeNode = new TreeNode(middleNode.val);
        //左子树
        treeNode.left = buildTree(left, middleNode);
        //右子树
        treeNode.right = buildTree(middleNode, right);
        return treeNode;
    }

    private ListNode findMiddleNode(ListNode left, ListNode right) {
        ListNode slow = left, fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
