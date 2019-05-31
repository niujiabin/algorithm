package wanghui.链表;

import common.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
