package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

/**
 * 执行用时 : 2 ms, 在Rotate List的Java提交中击败了98.55% 的用户
 * 内存消耗 : 35.1 MB, 在Rotate List的Java提交中击败了90.16% 的用户
 */
public class 旋转链表_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        //获取总数量 和最后一个元素
        ListNode node = head;
        ListNode last;
        int count = 0;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        last = node;
        count++;

        //倒数第k个元素
        int m = k % count;
        node = head;
        int x = 0;
        ListNode pre = null;
        while (count - m > x++) {
            pre = node;
            node = node.next;
        }

        if (m == 0 || pre == null) {
            return head;
        }

        last.next = head;
        pre.next = null;

        return node;
    }


    public static void main(String[] args) {

        ListNode node = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3)));
        ListNode result = new 旋转链表_61().rotateRight(node, 4);
        LinkListUtils.forEachElement(result);

    }
}
