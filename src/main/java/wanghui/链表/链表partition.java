package wanghui.链表;

import common.ListNode;

public class 链表partition {
    public static ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode stick1 = new ListNode(-1);
        ListNode stick2 = new ListNode(-1);
        ListNode cur1 = stick1;
        ListNode cur2 = stick2;
        while(head!=null) {
            if(head.val<x) {
                cur1.next = head;
                cur1 = cur1.next;
            }else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;//这行cur2的next要指向null，否则空间会超
        cur1.next = stick2.next;
        return stick1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode node =  partition(head, 3);
        while(node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
