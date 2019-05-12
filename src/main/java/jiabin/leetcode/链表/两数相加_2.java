package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * <p>
 * <p>
 * 执行用时 : 10 ms, 在Add Two Numbers的Java提交中击败了89.06% 的用户
 * 内存消耗 : 40.8 MB, 在Add Two Numbers的Java提交中击败了95.29% 的用户
 */


public class 两数相加_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode result = l1;
        ListNode preL1 = null;
        while (l1 != null && l2 != null) {
            preL1 = l1;
            sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (carry == 1 && preL1 != null) {
                preL1.next = new ListNode(1);
            }
        } else {
            if (l1 == null) {
                preL1.next = l2;
                l1 = l2;
            }
            while (l1 != null) {
                preL1 = l1;
                sum = l1.val + carry;
                l1.val = sum % 10;
                carry = sum / 10;
                l1 = l1.next;
            }
            if (carry == 1 && preL1 != null) {
                preL1.next = new ListNode(1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9).setNext(new ListNode(9));

        ListNode result = new 两数相加_2().addTwoNumbers(l1, l2);

        LinkListUtils.forEachElement(result);

    }

}
