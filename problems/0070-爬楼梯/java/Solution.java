public class Solution {
    public static void main(String[] args){}

    public int climbStairs(int n) {
        int dp[] = new int[n + 1];// 创建一个 dp 数组, 每一个格子记录有多少种很难过方法可以到达该位置
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
