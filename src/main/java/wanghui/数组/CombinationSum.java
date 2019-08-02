package wanghui.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        getResult(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }

    public void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {

        if(target>0) {
            for(int i=start; i<candidates.length && target>=candidates[i]; ++i) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target-candidates[i], i);
                cur.remove(cur.size()-1);
            }
        }else if(target==0){
            result.add(new ArrayList<Integer>(cur));
        }
    }


}
