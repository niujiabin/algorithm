package wanghui.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null || nums.length==0) {
            return ans;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; ++i) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(nums[i] > 0) break;
            int j=i+1;
            int k = nums.length-1;
            while(j<k) {
                if(j>i+1 && nums[j]==nums[j-1]) {
                    j++;
                    continue;
                }
                if(nums[i]+nums[j]>0) break;
                if(nums[i]+nums[j]+nums[k]<0) {
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0) {
                    k--;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}
