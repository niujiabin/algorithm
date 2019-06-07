package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

public class 分隔链表 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1).
                setNext(new ListNode(2).
                        setNext(new ListNode(3).
                                setNext(new ListNode(4).
                                        setNext(new ListNode(5)
                                        ))));
        ListNode[] s = new 分隔链表().splitListToParts(node, 3);
        for (ListNode x : s) {
            LinkListUtils.forEachElement(x);
        }

    }

    /**
     * 1、获取节点数量
     * 2、判断每个数组节点数量
     * 3、再次循环设置节点
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode node = root;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        node = root;
        int mod = length % k;
        int size = length / k;
        ListNode result[] = new ListNode[k];
        for (int i = 0; node != null && i < k; i++) {
            result[i] = node;
            int curSize = size + (mod-- > 0 ? 1 : -0);
            for (int j = 0; j < curSize - 1; j++) {
                node = node.next;
            }
            ListNode next = node.next;
            node.next = null;
            node = next;
        }
        return result;
    }
}
