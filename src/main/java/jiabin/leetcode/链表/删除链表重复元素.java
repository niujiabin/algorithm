package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

public class 删除链表重复元素 {

    /**
     * 执行用时 : 2 ms, 在Remove Duplicates from Sorted List的Java提交中击败了73.10% 的用户
     * 内存消耗 : 36.5 MB, 在Remove Duplicates from Sorted List的Java提交中击败了67.49% 的用户
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        ListNode nnext;
        while (head.next != null) {
            if (head.val == head.next.val) {
                if (head.next.next != null) {
                    nnext = head.next.next;
                    head.next.next = null;
                    head.next = nnext;
                } else {
                    head.next = null;
                    break;
                }
            } else {
                head = head.next;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        ListNode node = new ListNode(1).setNext(new ListNode(1).setNext(new ListNode(1).setNext(new ListNode(2))));
        ListNode result = new 删除链表重复元素().deleteDuplicates(node);
        LinkListUtils.forEachElement(result);

    }
}
