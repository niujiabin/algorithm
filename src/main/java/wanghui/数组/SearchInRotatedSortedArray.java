package wanghui.数组;

public class SearchInRotatedSortedArray {


    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid]<nums[right]) {
                if(target>nums[mid] && target<=nums[right]) {
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }

            if(nums[mid]>nums[left]) {
                if(target<nums[mid] && target>=nums[left]) {
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }

        }
        return -1;
    }


}
