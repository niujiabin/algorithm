package wanghui.数组;

import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        for(int i=0; i<nums.length&&i<3; ++i) {
            closest += nums[i];
        }
        if(nums.length<3) return closest;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; ++i) {
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                closest = Math.abs(sum-target) < Math.abs(closest-target) ? sum : closest;
                if(sum==target) {
                    return closest;
                }else if(sum<target) {
                    j++;
                }else {
                    k--;
                }
            }
        }
        return closest;
    }
}
