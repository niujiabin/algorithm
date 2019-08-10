package wanghui.数组;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if(matrix==null || matrix.length==0) {
                return ans;
            }
            int sx = 0;
            int sy = 0;
            int ex = matrix.length-1;
            int ey = matrix[0].length-1;
            while(sx<ex && sy<ey) {
                for(int i=sy; i<ey; ++i) {
                    ans.add(matrix[sx][i]);
                }
                for(int i=sx; i<ex; ++i) {
                    ans.add(matrix[i][ey]);
                }
                for(int i=ey; i>sy; --i) {
                    ans.add(matrix[ex][i]);
                }
                for(int i=ex; i>sx; --i) {
                    ans.add(matrix[i][sy]);
                }
                sx++;
                sy++;
                ex--;
                ey--;
            }
            if(sx==ex && sy==ey) {
                ans.add(matrix[sx][sy]);
            }else if(sx==ex&&sy!=ey) {
                for(int i=sy; i<=ey; ++i) {
                    ans.add(matrix[sx][i]);
                }
            }else if(sx!=ex&&sy==ey){
                for(int i=sx; i<=ex; ++i) {
                    ans.add(matrix[i][sy]);
                }
            }
            return ans;
        }
    }
}
