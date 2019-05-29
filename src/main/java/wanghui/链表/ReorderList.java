package wanghui.链表;

import common.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre  = null;
        ListNode cur = slow.next;
        slow.next = null;
        ListNode next = null;
        //右半侧反转
        while(cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode newHead = new ListNode(-1);
        ListNode stick = newHead;
        ListNode lhead = head;
        ListNode rhead = pre;
        ListNode lnext = null;
        ListNode rnext = null;
        //重新组织链表
        while(lhead!=null && rhead!=null) {
            lnext = lhead.next;
            rnext = rhead.next;
            stick.next = lhead;
            lhead.next = rhead;
            stick = stick.next.next;
            lhead = lnext;
            rhead = rnext;
        }
        stick.next = lhead==null?rhead:lhead;
        head = newHead.next;
    }
}
