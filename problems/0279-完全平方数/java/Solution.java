import java.util.Arrays;

class Solution {
    public static void main(String[] args){
        new Solution().numSquares(12);
    }
    public int numSquares(int n) {
        // 先遍历一下, 所有 平方数小于 n 的, 比如 13, 那么遍历 1 ^ 2 = 1, 2 ^ 2 = 4, 3 ^ 2 = 9, 就停止了
        // dp[i] 表示构成 i 所需要的最少的 平方数 数量
        // dp[i - j^2] 这里 dp[j^2] 肯定是 == 1 的
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]); // 这里的 1 实际上就是 dp[j^2] == 1
            }
        }
        Arrays.stream(dp).forEach(System.out::println);
        return dp[n];
    }   
}