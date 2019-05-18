package wanghui.链表;
import common.ListNode;

/**
 * 从有往左数的k个节点移到左边，如果到了最左边，重新回到尾节点
 * 几个重要的case
 *  0->1->2->NULL, k = 4   结果   2->0->1->NULL
 * 0->1->2->NULL, k = 3   结果   0->1->2->NULL
 *  0->1->2->NULL, k = 6  结果   0->1->2->NULL k是6，total是3，6可以整除3
 */
public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) {
            return head;
        }

        ListNode pre = null;
        ListNode last = null;
        ListNode cur = head;
        int total = 0;
        //找到尾节点
        while(cur!=null) {
            last = cur;
            cur = cur.next;
            total++;
        }
        //找到新的头结点,从左数total-k个元素
        cur = head;
        //如果k大与链表总长度，那么就取余，k=4,total=3,那么k就变成1
        k = k%total;
        //如果total能被k整除，那么就绕回了头结点
        if(k==total || k==0) {
            return head;
        }
        int count = total-k;
        while(cur!=null && count>0) {
            pre = cur;
            cur = cur.next;
            count--;
        }
        pre.next=null;
        last.next = head;
        return cur;
    }
}
