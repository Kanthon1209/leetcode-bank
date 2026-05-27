class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        int max = Integer.MIN_VALUE;
        // dp[i] 表示以当前元素为结尾的连续子数组乘积的最大可能值
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], nums[i]), nums[i] * dpMin[i - 1]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], nums[i]), nums[i] * dpMin[i - 1]);
            if(dpMax[i] > max) max = dpMax[i];
        }
        return max;
    }
}