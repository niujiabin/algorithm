package wanghui.链表;

import common.ListNode;

public class 删除重复链表Ⅰ {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null) {
            next = cur.next;
            if(next==null) {
                return head;
            }else {
                if(cur.val==next.val) {
                    cur.next = next.next;
                    next.next=null;
                }else {
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}
