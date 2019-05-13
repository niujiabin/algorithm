package wanghui.链表;

public class 复杂链表复制 {
    static public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    /**
     * 用map的解法
     * @param pHead
     * @return
     */
//    public RandomListNode Clone1(RandomListNode pHead) {
//
//        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
//        RandomListNode cur = pHead;
//        while(cur!=null) {
//            map.put(cur, new RandomListNode(cur.label));
//            cur = cur.next;
//        }
//        cur = pHead;
//        RandomListNode next = null;
//        while(cur!=null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(pHead);
//    }

    /**
     * 复制节点方式
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null) {
            return null;
        }
        //复制每一个节点
        RandomListNode cur = pHead;
        RandomListNode next = null;
        while(cur!=null) {
            next = cur.next;
            RandomListNode copyNode = new RandomListNode(cur.label);
            cur.next = copyNode;
            copyNode.next = next;
            cur = next;
        }
        //处理每一个random节点
        cur = pHead;
        while (cur!=null) {
            next = cur.next.next;
            RandomListNode copyNode = cur.next;
            copyNode.random = cur.random==null?null:cur.random.next;
            cur = next;
        }
        //拆分链表
        cur = pHead;
        RandomListNode newHead= pHead.next;
        while (cur!=null) {
            next = cur.next.next;
            RandomListNode copyNode = cur.next;
            copyNode.next = copyNode==null?null:copyNode.next.next;
            cur.next = next;
            cur = cur.next;
        }

        return newHead;
    }
}
