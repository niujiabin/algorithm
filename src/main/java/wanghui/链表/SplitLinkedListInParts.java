package wanghui.链表;

import common.ListNode;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        int nodeArrSize = k;
        ListNode cur = root;
        while (cur!=null) {
            count++;
            cur = cur.next;
        }
        int partSize = (count/k);
        int mod = count%k;
        ListNode[] res = new ListNode[k];
        cur = root;
        if(partSize == 0) {
            for(int i=0; i<k; ++i) {
                ListNode item = cur;
                ListNode next = cur==null?null:cur.next;
                if(cur!=null) {
                    cur.next = null;
                }
                cur = next;
                res[i] = item;
            }
        }else {
            for(int i=0; i<k; ++i) {
                ListNode item = cur;
                for(int j=0; j<partSize-1; ++j) {
                    cur = cur.next;
                }
                if(mod-->0) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
                res[i] = item;
            }
        }

        return res;
    }
}
