package wanghui.数组;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cur = 0;
        for(int i=0; i<nums.length; ++i) {
            cur = cur+nums[i];
            ans = Math.max(ans, cur);
            cur = cur<0?0:cur;
        }
        return ans;
    }
}
