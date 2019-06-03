package jiabin.leetcode.链表;

import common.ListNode;

import java.util.List;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next== null){
            return false;
        }
        //检测链表是否有环  快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
