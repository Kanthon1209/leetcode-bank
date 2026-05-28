import java.util.Arrays;

public class Solution {
    int[][] memo;

    public int minPathSum(int[][] grid) {
        return minPathSumDFS(grid);//
        // return minPathSumDP(grid);
    }

    public int minPathSumDP(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        int[][] dp = new int[rowNum][colNum];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rowNum; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < rowNum; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 全都初始化为0
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < colNum; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[rowNum - 1][colNum - 1];
    }

    public int minPathSumDFS(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        this.memo = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            Arrays.fill(this.memo[i], -1);
        }

        return dfs(grid, 0, 0);
    }

    public int dfs(int[][] grid, int i, int j) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        if (i >= rowNum || j >= colNum)
            return Integer.MAX_VALUE / 2;
        if (i == rowNum - 1 && j == colNum - 1) {
            memo[i][j] = grid[i][j];
            return grid[i][j];
        }
        if (memo[i][j] == -1) {
            memo[i][j] = grid[i][j] + Math.min(dfs(grid, i + 1, j), dfs(grid, i, j + 1));
        }
        return memo[i][j];
    }
}
