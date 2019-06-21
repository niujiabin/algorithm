package wanghui.栈;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzanLevelOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            travel(root, ans, 0);
            return ans;
        }

        private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
            if(curr==null) {
                return;
            }
            if(sol.size()<=level) {
                List<Integer> newLevel = new LinkedList<>();
                sol.add(newLevel);
            }
            List<Integer> collection = sol.get(level);
            if(level%2==0) {
                collection.add(curr.val);
            }else {
                collection.add(0, curr.val);
            }
            travel(curr.left, sol, level+1);
            travel(curr.right, sol, level+1);
        }

}
