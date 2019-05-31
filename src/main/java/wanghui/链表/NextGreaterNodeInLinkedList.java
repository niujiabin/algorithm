package wanghui.链表;

import common.ListNode;

public class NextGreaterNodeInLinkedList {
    /**
     * 最朴素的解法
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        if(head==null) {
            return null;
        }
        int size = 0;
        ListNode cur = head;
        while(cur!=null) {
            size++;
            cur = cur.next;
        }
        int[] ans = new int[size];
        int index = 0;
        cur = head;
        outer: while(head!=null) {
            cur = head;
            while(cur!=null) {
                if(cur.val>head.val) {
                    ans[index++] = cur.val;
                    head = head.next;
                    continue outer;
                }
                cur = cur.next;
            }
            if(cur==null) {
                ans[index++] = 0;
            }
            head = head.next;
        }
        return ans;
    }
}
