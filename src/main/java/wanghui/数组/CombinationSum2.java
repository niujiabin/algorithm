package wanghui.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> cur, int[] candidates, int target, int start) {
        if(target==0) {
            ans.add(new ArrayList<>(cur));
        }else if(target>0) {
            //
            for(int i=start; i<candidates.length && target-candidates[i]>0; ++i) {
                /**
                 * 去重
                 */
                if(i>start && candidates[i]==candidates[i-1]) continue;
                cur.add(candidates[i]);
                dfs(ans, cur, candidates, target-candidates[i], i+1);
                cur.remove(cur.size()-1);
            }
        }
    }


}