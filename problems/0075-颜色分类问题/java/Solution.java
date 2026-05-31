public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            while(i >= left && i <= right && (nums[i] == 0 || nums[i] == 2)){}
                if(nums[i] == 0){
                    swap(nums, i, left);
                    left++;
                }
                if(nums[i] == 2){
                    swap(nums, i, right);
                    right--;
                }
            }
        }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}