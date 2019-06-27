package wanghui.栈;

import java.util.Stack;

public class LargestRectangleInHistogram {

        public int largestRectangleArea(int[] heights) {
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

}
