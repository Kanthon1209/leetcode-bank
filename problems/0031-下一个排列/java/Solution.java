import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIdx = nums.length - 1;
        boolean flag = true;
        for(int i = nums.length - 1; i >= 1; i--){
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }
            if(nums[i] > nums[i - 1]){
                swap(nums, i - 1, minIdx);
                Arrays.sort(nums, i, nums.length - 1);
                flag = false;
                break;
            }
        }
        if(flag){
            Arrays.sort(nums);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}