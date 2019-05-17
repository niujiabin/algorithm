package wanghui.链表;

import common.ListNode;

public class 删除重复链表Ⅱ {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) {//只有一个节点
            return head;
        }


        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur!=null && cur.next!=null) {
            next = cur.next;
            //当前节点值与next不同
            if(cur.val!=next.val) {
                pre = cur;
                cur = next;
                next = cur.next;
            }else {//当前节点值与next相同
                if(pre==null){//如果当前处理的是头结点
                    cur = deleteNode(cur, next);
                    head = cur;
                }else {//当前处理的节点不是头结点
                    cur = deleteNode(cur, next);
                    pre.next = cur;
                }
            }
        }
        return head;
    }

    public ListNode deleteNode (ListNode cur, ListNode next) {
        while(cur!=null && next!=null && cur.val==next.val) {
            next = cur.next.next;
            cur.next = next;
        }
        if(next==null) {
            return null;
        }else {
            return next;
        }
    }
}
