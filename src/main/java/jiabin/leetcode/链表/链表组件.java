package jiabin.leetcode.链表;

import common.ListNode;

public class 链表组件 {

    public int numComponents(ListNode head, int[] G) {
        if (head == null) return 0;
        int[] arr = new int[10000];
        arr[0] = -1;
        for (int i = 0; i < G.length; i++) {
            arr[G[i]] = G[i];
        }
        int count = 0;
        boolean flag = false;
        while (head != null) {
            if (arr[head.val] != head.val) {
                flag = false;
            } else {
                count = !flag ? count + 1 : count;
                flag = true;
            }
            head = head.next;
        }
        return count;
    }

}
