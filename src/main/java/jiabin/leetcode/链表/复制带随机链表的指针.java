package jiabin.leetcode.链表;

import common.ListNode;
import common.Node;

public class 复制带随机链表的指针 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        //将克隆节点放在原节点后面
        while (node != null) {
            Node clone = new Node(node.val, node.next, null);
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        //处理random指针    这个处理很是巧妙啊
        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        //分离原始链表和克隆链表
        node = head;
        Node cloneHead = head.next;
        while (node.next != null) {
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;


    }
}
