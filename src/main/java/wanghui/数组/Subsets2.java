package wanghui.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if(nums==null || nums.length==0) return ans;
            Arrays.sort(nums);
            dfs(ans, new ArrayList<Integer>(), nums, 0);
            return ans;
        }

        public void dfs(List<List<Integer>> ans, List<Integer> cur, int[] nums, int pos ) {
            if(pos <= nums.length) ans.add(cur);
            int i = pos;
            while(i<nums.length) {
                cur.add(nums[i]);
                dfs(ans, new ArrayList<Integer>(cur), nums, i+1);
                cur.remove(cur.size()-1);
                i++;
                while(i<nums.length && nums[i]==nums[i-1]) i++;
            }
            return ;
        }
    }
}
