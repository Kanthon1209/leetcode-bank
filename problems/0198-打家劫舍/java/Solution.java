class Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        dp[0] = nums[0];// dp[i] 表示的是[0, i]能够取得的最大收益
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);// 如果选中了当前这个位置的, 那么i - 1的就不能选择
            // 再前面的就无所谓了
        }
        return dp[nums.length - 1];
    }
}