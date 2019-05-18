package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class 分割链表 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1).setNext(new ListNode(4)
                .setNext(new ListNode(3).setNext(new ListNode(2)
                        .setNext(new ListNode(5).setNext(new ListNode(2))))));

        ListNode res = new 分割链表().partition(node, 3);
        LinkListUtils.forEachElement(res);
    }

    /**
     * 思想  快速排序
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode find = head;
        ListNode find_pre = dummy;

        //dummy (tail find_follow)  head(find)
        while (find != null) {
            if (find.val < x) {
                if (find == head || find_pre == tail) {
                    find_pre = find;
                    find = find.next;
                    tail = tail.next;
                    continue;
                }

                ListNode tmp = tail.next;
                find_pre.next = find.next;
                tail.next = find;
                find.next = tmp;

                tail = find;
                find = find_pre.next;

            } else {
                find_pre = find;
                find = find.next;
            }
        }
        return dummy.next;
    }

}
