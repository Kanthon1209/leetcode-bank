import java.util.Arrays;

public class Solution {
    public static void main(String[] args){}

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];// dp[i]表示以nums[i]为结尾的最长递增子序列长度
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > maxValue){
                maxValue = dp[i];
            }
        }
        return maxValue;
    }
}
