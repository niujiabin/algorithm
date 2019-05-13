package wanghui.链表;

import common.ListNode;

public class 倒数第K个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && k>0) {
            fast = fast.next;
            k--;
        }
        if(k>0) {
            return null;
        }else {
            while(fast!=null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
