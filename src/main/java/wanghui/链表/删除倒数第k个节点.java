package Test;

public class 删除倒数第k个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) {
            return head;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&& n>0) {
            fast = fast.next;
            n--;
        }
        if(n>0) {
            return head;
        }else {
            while(fast!=null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next;
            }
            if(pre==null){//要删除的是第一个节点
                head = slow.next;
                slow.next = null;
                return head;
            }
            if(slow.next==null) {//要删除的是最后一个节点
                pre.next = null;
                return head;
            }
            pre.next = slow.next;//删除的是普通节点
            slow.next = null;
            return head;
        }
    }
}
