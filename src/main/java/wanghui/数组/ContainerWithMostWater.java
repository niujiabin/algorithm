package wanghui.数组;

public class ContainerWithMostWater {    public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
        return 0;
    }
    int low = 0;
    int high = height.length - 1;
    int max = Integer.MIN_VALUE;
    int cur = 0;
    while (low < high) {
        cur = (high - low) * Math.min(height[low], height[high]);
        max = Math.max(cur, max);
        if (height[low] < height[high]) {
            low++;
        } else {
            high--;
        }
    }
    return max;
}
}
