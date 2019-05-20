package wanghui.链表;

import common.ListNode;

public class 删除链表中的一个元素 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur!=null) {
            next = cur.next;
            if(cur.val==val) {
                if(pre==null) {//头结点
                    head = next;
                }else {
                    cur.next=null;
                    pre.next = next;
                }
            }else {
                pre = cur;
            }
            cur =  next;
        }
        return head;

    }
}
