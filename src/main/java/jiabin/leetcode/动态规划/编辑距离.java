package jiabin.leetcode.动态规划;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 编辑距离 {

    public int minDistance(String word1, String word2) {

        /**
         * 先找出递推公式
         *
         *      s[i] 想要变成  p[j]的最少次数记dp[i][j]
         *      s[i-1] 变为 p[j-1]之后在修改一个单词  （如果s[j] == p[j] 就不修改了），就是word2
         *      s[j-1] 变为  p[j] ,之后把s[j]删除 就是word2
         *      s[i]变为 p[j-1], 之后再加一个单词就是WORD2
         */


        /**
         * 关键点1 初始化
         *
         *
         * 关键点2：根据递推公式写代码
         *
         *
         * 关键点3：最终的返回结果
         *
         *
         * 关健点4：一些特殊的处理技巧
         */
        return 0;
    }

    public static void main(String[] args) {

    }
}
