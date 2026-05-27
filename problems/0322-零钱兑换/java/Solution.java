import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        // 小于最小硬币面值的都应该设置为 -1
        // 如果是 -1, 应该不纳入考虑, 如果都是-1, 那么当前位置无法兑换-
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int value : coins){
                if(i >= value){
                    dp[i] = Math.min(dp[i - value] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}