package wanghui.链表;
import common.ListNode;
public class 链表交换每两个节点 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        while(cur!=null && cur.next!=null) {
            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            //头结点的话，要把head指向第二个节点
            if(pre==null) {
                head = next;
            }else {
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
        }
        return head;
    }
}
