package wanghui.数组;

public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = findLeftIndex(nums, target);
        ans[1] = findRightIndex(nums, target);
        return ans;

    }

    public  int findLeftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right) {
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid]==target &&
                    ((mid>0 && nums[mid-1]!=target)
                            ||mid==0)) {
                return mid;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

    public  int findRightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right) {
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid]==target &&
                    ((mid<nums.length-1 && nums[mid+1]!=target)
                            || mid==nums.length-1)) {
                return mid;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
