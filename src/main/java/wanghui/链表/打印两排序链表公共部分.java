package wanghui.链表;

import common.ListNode;

public class 打印两排序链表公共部分 {
    public static void printCommonPart(ListNode head1, ListNode head2) {
        if(head1==null || head2==null) {
            return ;
        }
        ListNode start= null;
        while(head1!=null && head1!=null) {
            if(head1.val<head1.val) {
                head1 = head1.next;
            }else if(head1.val>head2.val) {
                head2 = head2.next;
            }else {
                start = head1;
                break;
            }
        }
        while(start!=null) {
            System.out.println(start.val);
            start = start.next;
        }
    }

}
