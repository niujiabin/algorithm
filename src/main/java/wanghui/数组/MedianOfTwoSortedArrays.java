package wanghui.数组;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0) {
            return medoNum(nums2);
        }
        if(nums2==null || nums2.length==0) {
            return medoNum(nums1);
        }
        int n = nums1.length;
        int m = nums2.length;
        if(n>m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int c1 = 0, c2=0, l1=0, r1=0, l2=0, r2=0, lo=0, hi=2*n;
        while (lo <= hi) {
            c1 = (lo+hi)/2;
            c2 = n+m-c1;
            l1 = c1==0?Integer.MIN_VALUE:nums1[(c1-1)/2];
            r1 = c1==2*n?Integer.MAX_VALUE:nums1[c1/2];
            l2 = c2==0?Integer.MIN_VALUE:nums2[(c2-1)/2];
            r2 = c2==2*m?Integer.MAX_VALUE:nums2[(c2)/2];
            if(l1>r2) {
                hi = c1-1;
            }else if(l2>r1) {
                lo = c1+1;
            }else{
                break;
            }
        }
        return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;

    }

    public  double medoNum(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        return (nums[nums.length/2] + nums[(nums.length-1)/2])/2.0;
    }


}
