package wanghui.数组;

/**
 * https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; ++i) {
            for(int j=i; j<matrix[0].length; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i=0; i<matrix.length; ++i) {
            for(int j=0; j<matrix.length/2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = tmp;
            }
        }

    }
}
