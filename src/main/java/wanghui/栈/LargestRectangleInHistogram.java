package wanghui.栈;

import java.util.Stack;

public class LargestRectangleInHistogram {

        public static int largestRectangleArea(int[] heights) {
            if(heights==null || heights.length==0) {
                return 0;
            }
            int ans = Integer.MIN_VALUE;
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<heights.length; ++i) {
                while (!stack.isEmpty() && heights[i]<heights[stack.peek()]) {
                    int cur = stack.pop();
                    ans = Math.max(ans, stack.isEmpty()?(i*heights[cur]) : (i-1-(stack.peek()+1)+1)*heights[cur]);
                }
                stack.push(i);
            }
            while(!stack.isEmpty()) {
                int cur = stack.pop();
                ans = Math.max(ans, stack.isEmpty()?(heights.length*heights[cur]) :
                        (heights.length-(stack.peek()+1))*heights[cur] );
            }
            return ans;
        }

    public static int getMax(int[] height) {
        if(height==null || height.length==0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<height.length; ++i) {
            while(!stack.isEmpty() && height[i]<height[stack.peek()]) {
                int cur = stack.pop();
                ans = Math.max(ans, stack.isEmpty()? i*height[cur] : (i-1-stack.peek())*height[cur]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            ans = Math.max(ans, stack.isEmpty() ? height.length*height[cur] :
                    (height.length-stack.peek()-1)*height[cur]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1, 1};
        System.out.println(getMax(height));
    }
}
