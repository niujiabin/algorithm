package 链表;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    public int getVal() {
        return val;
    }

    public ListNode setVal(int val) {
        this.val = val;
        return this;
    }
}
