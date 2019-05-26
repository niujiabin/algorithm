package wanghui.链表;

import common.ListNode;

public class 链表排序 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        //拆分成两个链表
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode res = merge(l1, l2);
        return res;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode stick = head;
        while(l1!=null && l2!=null) {

            if(l1.val<l2.val) {
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1==null?l2:l1;
        return stick.next;
    }
}
