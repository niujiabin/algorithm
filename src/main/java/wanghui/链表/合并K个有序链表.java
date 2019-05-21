package wanghui.链表;

import common.ListNode;

public class 合并K个有序链表 {
    //递归版本
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        if(lists.length==1) {
            return lists[0];
        }
        return process(lists, 0, lists.length-1);
    }

    public ListNode process (ListNode[] lists, int l, int r) {
        if(l>r) {
            return null;
        }
        if(l==r) {
            return lists[l];
        }
        int mid = (l+r)/2;
        ListNode head1 = process(lists, l, mid);
        ListNode head2 = process(lists, mid+1, r);
        ListNode res = merge(head1, head2);
        return res;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null) {
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        if(list1.val<list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        }else {
            list2.next = merge(list2.next, list1);
            return list2;
        }
    }

    /**
     * 非递归版
     *
     */

    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        if(lists.length==1) {
            return lists[0];
        }
        ListNode newHead = null;
        for (int i=0; i<lists.length; ++i) {
            newHead = merge1(newHead, lists[i]);
        }
        return newHead;
    }

    public ListNode merge1(ListNode list1, ListNode list2) {
        if(list1==null) {
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode trick = new ListNode(-1);
        ListNode start = trick;
        while (head1!=null && head2!=null) {
            if(head1.val<head2.val) {
                trick.next = head1;
                trick = trick.next;
                head1 = head1.next;
            }else {
                trick.next = head2;
                trick = trick.next;
                head2 = head2.next;
            }
        }
        trick.next = head1==null?head2:head1;
        return start.next;
    }
}
