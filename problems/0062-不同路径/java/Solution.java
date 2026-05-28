class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示到 i, j 有多少条路径, 只能从左边或者上边来
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        if(m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(i == 0){
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if(j == 0){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}