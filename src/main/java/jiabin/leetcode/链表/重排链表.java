package jiabin.leetcode.链表;

import common.ListNode;

import java.util.List;

/**
 * @author : jiabin.niu
 * @date : 2019.05.29 22:09
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class 重排链表 {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        //1 2 3 4 5

        //1 2 3 4
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针表示  如果有时候分不清 可以找四五个数据模拟一下  很快
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newNode = slow.next;
        slow.next = null;

        ListNode cur = newNode;
        ListNode pre = null;
        //链表翻转 记录prev
        //a ->b ->c
        //null  a(pre)   b(cur)  c(tempNode)
        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }

        //cur 1 2 3
        //pre 4 5
        cur = head;
        while (cur != null && pre != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = pre.next;

            cur.next = pre;
            cur = temp1;

            pre.next = temp1;
            pre = temp2;
        }


    }

}
