public class Solution {
    public static void main(String[] args){

    }

    public int maxSubArray(int[] nums) {
        // 最最关键的是认识到这是一个动态规划问题, 然后定义 dp 数组, 确定状态转移方程, 那么这题就结束了
        // 如何认识到这是一个动态规划问题:
            // 首先, 动态规划问题的明显特征是, 问题可以拆解成同构的子问题
            // 这道题要求的是 最大连续子串和
            // 那么这个和肯定是某一个连续子串和, 那么该子串包含了最后一个元素

            // 我们定义, dp[i] 表示以 i 位置元素为结尾元素的连续子串的最大和
            // 那么 dp[i] 的推导需要依赖 nums[i], 也就是状态转移方程中一定有 nums[i]
            // 对于 nums[i] 来说, 前面的最好是正数, 如果是负数, 那还不如自己一个等待和后面组合呢

        int[] dp = new int[nums.length];// 定义 dp 数组
        
        // 初始化 dp 数组
        dp[0] = nums[0];

        // 状态转移方程
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(var item : dp){
            if(item > max){
                max = item;
            }
        }
        return max;
    }
}
