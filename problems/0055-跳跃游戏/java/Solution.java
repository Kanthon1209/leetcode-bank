public class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int idx = 0;
        while(idx < max){
            idx++;
            if(nums[idx] + idx > max){
                max = nums[idx] + idx;
            } 
        }
    }
}