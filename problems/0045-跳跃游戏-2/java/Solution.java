class Solution {
    public int jump(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        int count = 1;// 第一步是肯定要跳的
        int currMax = nums[0];
        int tmp = 0; // 用于在当前区间内
        int idx = 0;// 访问元素的指针
        while(currMax < nums.length - 1){
            while(idx < currMax){
                idx++;
                if(nums[idx] + idx > tmp){
                    tmp = nums[idx] + idx;
                }
            }
            currMax = tmp;
            count++;
        }
        return count;
    }
}