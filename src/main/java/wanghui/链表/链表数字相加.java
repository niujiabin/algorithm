package wanghui.链表;

import common.ListNode;

public class 链表数字相加 {
    int mess = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode pre = null;
        //两个链表都不为空
        while(head1!=null && head2!=null) {
            pre = head1;
            // int m = head1.val;
            // int n = head2.val;
            head1.val = resolveVal(head1.val,head2.val);
            head1 = head1.next;
            head2 = head2.next;
        }
        //head1为空，把head2连接在后边
        if(head1==null) {
            pre.next = head2;
        }
        //如果处理完，pre后边还有节点需要处理
        while(pre.next!=null) {
            pre = pre.next;
            pre.val = resolveVal(pre.val, 0);
        }
        //如果最后还有没有进位的
        if(mess>0) {
            pre.next = new ListNode(mess);
        }
        return l1;
    }

    public int resolveVal(int m , int n) {
        int ans = (m+n+mess)%10;
        mess = (m+n+mess)/10;
        return ans;
    }
}
