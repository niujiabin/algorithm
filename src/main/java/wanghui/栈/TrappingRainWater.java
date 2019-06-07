package wanghui.栈;

public class TrappingRainWater {
    /**
     * 1、开两个临时数组
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        if(height==null || height.length==0|| height.length==1 || height.length==2) {
            return 0;
        }
        int[] lMax = new int[height.length];
        lMax[0] = height[0];
        for(int i=1; i<height.length; ++i) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }
        int[] rMax = new int[height.length];
        rMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; --i) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }
        int ans = 0;
        for(int i=1; i<height.length-1; ++i) {
            int tmp = Math.min(lMax[i-1], rMax[i+1]) - height[i];
            ans+=tmp<0?0 : tmp;
        }
        return ans;
    }

    /**
     * 开一个数组
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if(height==null || height.length==0 || height.length==1 || height.length==2) {
            return 0;
        }
        int ans = 0;
        int lMax = height[0];
        int[] rMax = new int[height.length];
        rMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; --i) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }
        for(int i=1; i<height.length-1; ++i) {
            int tmp = Math.min(lMax, rMax[i+1]) - height[i];
            ans+=tmp<0?0:tmp;
            lMax = Math.max(lMax, height[i]);
        }
        return ans;
    }

    /**
     * 不开数组
     *
     */
    public static int trap2(int[] height) {
        if(height==null || height.length==0 || height.length==1 || height.length==2) {
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = height.length-1;
        int lMax = height[0];
        int rMax = height[height.length-1];
        while (l<=r) {
            if(lMax<rMax) {
                ans+=lMax-height[l]<0?0:lMax-height[l];
                lMax = Math.max(lMax, height[l]);
                l++;
            }else {
                ans+=rMax-height[r]<0?0:rMax-height[r];
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(arr));
    }


}
