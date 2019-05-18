package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

import javax.swing.*;

public class 反转链表2 {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        //初始化虚拟结点
        ListNode result = initDummy(head);
        //curNode：当前遍历的节点
        ListNode curNode = head;
        //节点位置
        int index = 1;
        ListNode tail = result;
        while (curNode != null) {
            if (index >= m && index < n) {
                //把curNode.next放到 tail后面
                if (curNode.next != null) {
                    ListNode curNext = curNode.next;
                    curNode.next = curNext.next;
                    curNext.next = tail.next;
                    tail.next = curNext;
                    index++;
                    continue;
                }
            } else if (index < m) {
                //tail 表示最后一个小于m节点的节点
                tail = tail.next;
            }
            //更新指针 和计数
            index++;
            curNode = curNode.next;
        }
        return result.next;
    }

    private ListNode initDummy(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        return result;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1)
                .setNext(new ListNode(2)
                 .setNext(new ListNode(3).setNext(new ListNode(4)
                                .setNext(new ListNode(5)))));

        ListNode result = new 反转链表2().reverseBetween(node, 2, 5);
        LinkListUtils.forEachElement(result);

    }

}
