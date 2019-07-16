package jiabin.leetcode.动态规划;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 零钱兑换 {

    /**
     * sum[i] : 凑成i元所需要的最少的硬币数
     * <p>
     * 地推公式 sum[i] = min{sum[i-cost[0...j] + 1}
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //特殊处理
        //初始化,想要凑出coins[0..length-1]的钱数只需要一枚硬币就够了
        int sum[] = new int[amount + 1];
        //假设最少需要的金币是金钱的最大数量+1，若果最后a

        /**
         * !! 技巧重点，初始化每一种金钱所需要的最小金币数量以1作为基准的最多数量 + 1 ，可以表示最大的金币数量
         *
         * 推到出递推公式之后，初始化也是很重的一个部分
         */
        Arrays.fill(sum, amount + 1);
        sum[0] = 0;
        //想要凑齐amount的钱数
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    //我想拼6块钱，如果硬币有1,2,5
                    // (1)如果以前已经拼了5块,  我再多使用一个1元的
                    //(2)如果之前已经有能拼成6块的
                    sum[i] = Math.min(sum[i], sum[i - coins[j]] + 1);
                }
            }
        }

        return sum[amount] > amount ? -1 : sum[amount];
    }

    public static void main(String[] args) {
        int result = new 零钱兑换().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(result);
    }

}
