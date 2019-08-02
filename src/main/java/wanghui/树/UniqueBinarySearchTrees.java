package wanghui.树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return getTree(1, n);
    }

    public List<TreeNode> getTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start>end) {
            list.add(null);
            return list;
        }
        if(start==end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for(int i=start; i<=end; ++i) {
            left = getTree(start, i-1);
            right = getTree(i+1, end);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }

}
