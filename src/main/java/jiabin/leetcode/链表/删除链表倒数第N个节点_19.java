package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

/**
 * @author Administrator
 */
public class 删除链表倒数第N个节点_19 {

    /**
     * 关键：
     * (1)一次遍历找到倒数第N个节点
     * (2)单向链表删除时，要记录前面的节点
     *
     * @param head
     * @param n
     * @return 执行用时 : 2 ms, 在Remove Nth Node From End of List的Java提交中击败了94.88% 的用户
     * 内存消耗 : 34.4 MB, 在Remove Nth Node From End of List的Java提交中击败了89.63% 的用户
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode result = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        //fast先走
        while (fast != null && n-- > 0) {
            fast = fast.next;
        }

        //fast 为空 说明删除的是头结点
        if (fast == null) {
            return head.next;
        }

        //一起走  同时记录slow 的 前置节点
        while (slow != null && fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        //可以删除倒数第N个节点
        if (pre != null && pre.next != null) {
            pre.next = slow.next;
            slow.next = null;
        }
        //返回原头节点
        return result;
    }


    public static void main(String[] args) {

        ListNode result = new 删除链表倒数第N个节点_19().removeNthFromEnd(new ListNode(2).setNext(new ListNode(1)), 2);
        LinkListUtils.forEachElement(result);

    }
}
