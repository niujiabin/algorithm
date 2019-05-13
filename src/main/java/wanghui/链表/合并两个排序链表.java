
package wanghui.链表;

import common.ListNode;

public class 合并两个排序链表 {

    public static ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null) {
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        ListNode trick = new ListNode(-1);
        ListNode start = trick;
        ListNode head1 = list1;
        ListNode head2 = list2;
        while(head1!=null && head2!=null) {
            if(head1.val<head2.val) {
                trick.next = head1;
                trick = trick.next;
                head1 = head1.next;
            }else {
                trick.next = head1;
                trick = trick.next;
                head2 = head2.next;
            }
        }
        trick.next = head1==null?head2:head1;
        return start.next;
    }
    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list1;
        list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(7);

        ListNode list2;
        list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(10);
        list2.next.next.next.next = new ListNode(11);

        printLinkedList(merge(list1, list2));
    }
}
