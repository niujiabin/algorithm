package wanghui.链表;

import common.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenStick = evenHead;
        while(evenHead!=null&&evenHead.next!=null) {
            oddHead.next = oddHead.next.next;
            evenHead.next = evenHead.next.next;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = evenStick;
        return head;
    }
}
