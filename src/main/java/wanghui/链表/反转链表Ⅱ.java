package wanghui.链表;
import common.ListNode;

public class 反转链表Ⅱ {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n) {
            return head;
        }

        ListNode cur = head;
        ListNode nodeM = null;
        ListNode nodeN = null;
        ListNode pre = null;
        ListNode next = null;
        //包括首节点的情况
        if(m==1) {
            nodeM = head;
            while(cur!=null && n>0) {
                nodeN = cur;
                n--;
                next = cur.next;
                cur = next;
            }
            doReverse(pre, nodeM, nodeN);
            return nodeN;
        }else {//不包含首节点
            while (cur!=null && n>0) {
                m = m-1;
                if(m==1) {//找到pre节点
                    pre = cur;
                }
                if(m==0) {//找到m节点
                    nodeM = cur;
                }
                if(--n==0) {//找到n节点
                    nodeN = cur;
                }
                next = cur.next;
                cur = next;
            }
            doReverse(pre, nodeM, nodeN);
            return head;
        }


    }

    public void doReverse(ListNode pre, ListNode nodeM, ListNode nodeN){
        ListNode end = nodeN.next;
        ListNode newPre = pre;
        ListNode newNext = null;
        ListNode cur = nodeM;
        while(cur!=end) {
            newNext = cur.next;
            cur.next = newPre;
            newPre = cur;
            cur = newNext;
        }
        //带头节点的反转
        if(pre==null) {
            nodeM.next = end;
        }else {//不带头结点
            pre.next = nodeN;
            nodeM.next = end;
        }
    }
}
