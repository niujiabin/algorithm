package jiabin.leetcode.链表;

import common.LinkListUtils;
import common.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 合并k个有序链表 {

    private static final Comparator<ListNode>  comp =new Comparator<ListNode>() {

        public int compare(ListNode o1, ListNode o2) {
            // TODO Auto-generated method stub
            return o1.val-o2.val;
        }
    };

    public static ListNode mergeKLists(List<ListNode> lists){
        if(lists.size()==0||lists==null){
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.size(),comp);
        for(int i=0;i<lists.size();i++){
            ListNode node=lists.get(i);
            while(node!=null){
                ListNode temp=node;
                node=node.next;
                temp.next=null;
                queue.add(temp);
            }
        }
        ListNode result=new ListNode(-1);
        ListNode t=result;
        while(!queue.isEmpty()){
            t.next=queue.poll();
            t=t.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

       /* ListNode[] a = new ListNode[]{};
        ListNode result = new 合并k个有序链表().mergeKLists(a);

        LinkListUtils.forEachElement(result);*/
 /*       for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] == null ? "null" : a[i].val);
        }*/
    }
}
