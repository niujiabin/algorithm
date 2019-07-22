package wanghui.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            //if(nums[i]==nums[i+1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                //if(nums[j]==nums[j+1]) continue ll ;
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) {
                        m++;
                    } else if (sum > target) {
                        n--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        String str = "" + nums[i] + nums[j] + nums[m] + nums[n];
                        if (!set.contains(str)) {
                            ans.add(list);
                            set.add(str);
                        }
                        m++;
                        n--;
                    }
                }
            }
        }
        return ans;
    }
}
