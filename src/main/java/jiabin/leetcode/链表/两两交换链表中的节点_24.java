package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

/**
 * 执行用时 : 1 ms, 在Swap Nodes in Pairs的Java提交中击败了94.77% 的用户
 * 内存消耗 : 34 MB, 在Swap Nodes in Pairs的Java提交中击败了90.28% 的用户
 */
public class 两两交换链表中的节点_24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //最终的返回结果
        ListNode result = head.next;

        //存储第二个节点
        ListNode second = result;
        //存储第一个节点
        ListNode first = head;
        ListNode firstPre = null;
        //如果第一个节点后面 还有第二个节点
        while (first != null) {
            second = first.next;
            if (second != null) {
                first.next = second.next;
                second.next = first;
                if (firstPre != null) {
                    firstPre.next = second;
                }
                firstPre = first;
                first = first.next;
            } else {
                firstPre.next = first;
                break;
            }

        }

        return result;

    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4))));
        ListNode result = new 两两交换链表中的节点_24().swapPairs(node);
        LinkListUtils.forEachElement(result);
    }

}
