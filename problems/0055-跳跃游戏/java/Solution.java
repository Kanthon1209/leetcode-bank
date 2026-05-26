public class Solution {
    public boolean canJump(int[] nums) {
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            max--;
            if(nums[i] > max){
                max = nums[i];
            }
            if(max <= 0 && i < nums.length - 1){
                return false;
            }
        }
        return true;
    }
}
