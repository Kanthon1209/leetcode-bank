class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1]; // dp[i] 表示能不能构成 i
        dp[0] = true;
        // [0, target], 一共 target + 1 个元素
        for(int num : nums){
            for(int i = target; i >= num; i--){
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}

/*
们的目标是要凑出 target, 我们用动态规划来做, dp[i] 表示能不能凑出i, 那么 dp[target] 就是我们要求的答案, 所以我们要创建一个 size 为 target + 1 的数组, 因为dp[0] 开始, 我们开始遍历每一个元素, 每遍历一个元素我们都把dp 全部更新一遍, 当然,如果 j 小于当前元素的话, 那就不用更新了, 因为更小的元素不可能会依赖更大的元素去构成, 所以我们每遍历一个 num : nums, 对 dp 中的 i == target, i >= num; i--, 开始遍历, 但是为什么要从大的开始呢, 试想一下, 如果当前元素是3, target = 6, 如果从小的开始遍历, 那么dp[3] = true, 然后再更新 dp[6] = dp[6] || dp[3] 就为 true, 了, 你不能用一个 3 去同时凑3 和 凑 6 一个3 只能凑一遍?

当心状态污染
*/