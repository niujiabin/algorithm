package wanghui.数组;

public class JumpGame2 {

    public static int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int newEnd = Integer.MIN_VALUE;
        int ans = 0;
        while(end<nums.length-1) {
            for(int i=start; i<=end; ++i) {
                newEnd = Math.max(newEnd, i+nums[i]);
            }
            start=end+1;
            end = newEnd;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
