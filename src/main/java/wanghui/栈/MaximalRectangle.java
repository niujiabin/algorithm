package wanghui.栈;

import java.util.Stack;

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int[] tmparr = new int[matrix[0].length];

        for(int i=0; i<matrix.length; ++i) {
            tmparr = new int[matrix[0].length];
            for(int j=i; j<matrix.length; ++j) {
                for(int k=0; k<matrix[0].length; ++k) {
                    tmparr[k]+=matrix[j][k]-48;
                }
                ans = Math.max(ans, getMax(tmparr));
            }
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
                    (height.length-stack.pop()-1)*height[cur]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
